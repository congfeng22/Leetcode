import java.util.Arrays;

public class PerfectSquares279 {
    public int numSquares(int n) {
        // dp[i] = least num. of square that sum to i
        if (n<4) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0; dp[1]=1; dp[2]=2;
        for (int i=3;i<n+1;i++){
            for (int j=1;j<=Math.sqrt(i);j++){
                dp[i] = Math.min(dp[i],1+dp[i-j*j]);
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        PerfectSquares279 test = new PerfectSquares279();
        System.out.println(test.numSquares(12));
    }
}
