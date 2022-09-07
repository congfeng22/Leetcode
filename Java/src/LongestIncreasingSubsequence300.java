import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        //dp[i] = longest increasing subsequence ending at idx i
        int[] dp = new int[nums.length];
        dp[0]=1;
        int max = 1;
        for (int i=1;i<nums.length;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]) dp[i]=Math.max(dp[i],1+dp[j]);
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}
