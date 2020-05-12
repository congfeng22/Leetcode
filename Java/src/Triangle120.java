import java.util.List;

public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // n = number of levels, length of bottom level
        int n = triangle.size();
        // dp[i] = minimum total starting at i-th index row
        int[] dp = new int[n];
        // base case: minimum total is just bottom row
        for (int i=0;i<n;i++){
            dp[i] = triangle.get(n-1).get(i);
        }
        // counting up the rows
        for (int i=n-2;i>=0;i--){
            // moving right the cols
            for (int j=0;j<i+1;j++){
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
