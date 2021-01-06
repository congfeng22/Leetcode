import java.util.Arrays;

public class PalindromePartitioningII132 {
    public int minCut(String s) {
        // ptable[i][j] = whether index i to index j is a palindrome
        boolean[][] ptable = new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++){
            ptable[i][i] = true;
        }
        for (int i=s.length()-1;i>=0;i--){
            for (int j=s.length()-1;j>i;j--){
                ptable[i][j] = (s.charAt(i) == s.charAt(j)) && (i + 1 == j || ptable[i + 1][j - 1]);
            }
        }
        // for (boolean[] r:ptable) System.out.println(Arrays.toString(r));
        // dp[i] = mincut from 0 to i idx
        if (ptable[0][s.length()-1]) return 0;
        int[] dp = new int[s.length()];
        dp[0]=0;
        for (int i=1;i<s.length();i++){
            if (!ptable[0][i]){
                dp[i] = Integer.MAX_VALUE;
                for (int j=1;j<=i;j++){
                    if (ptable[j][i]){
                        dp[i] = Math.min(dp[j-1]+1,dp[i]);
                    }
                }
            }
        }
        return dp[s.length()-1];
    }
    public int bs(int num, int[] arr, int l, int r){
        if (l==r) return l;
        int m = (l+r)/2;
        if (arr[m]>=num) return bs(num,arr,l,m);
        else return bs(num,arr,m+1,r);
    }
    public static void main(String[] args){
        PalindromePartitioningII132 test = new PalindromePartitioningII132();
        String s = "abbab";
        //System.out.println(test.minCut(s));
        int[] arr = {0,0,1,1,1,1,1,1,2};
        System.out.println(test.bs(2,arr,0,8));
    }
}
