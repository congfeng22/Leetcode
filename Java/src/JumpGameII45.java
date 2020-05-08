public class JumpGameII45 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=0;
        for (int i=1;i<nums.length;i++){
            int min = nums.length;
            for (int j=0;j<i;j++){
                if (nums[j]+j>=i) min = Math.min(dp[j]+1,min);
            }
            dp[i]=min;
        }
        return dp[nums.length-1];
    }
    public static void main(String[] args){
        JumpGameII45 test = new JumpGameII45();
        int[] t = {2,3,1,1,4};
        System.out.println(test.jump(t));
    }
}
