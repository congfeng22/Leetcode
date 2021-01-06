public class HouseRobber198 {
    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        else if (nums.length==1) return nums[0];
        else if (nums.length==2) return Math.max(nums[0],nums[1]);
        int pprev =nums[0]; int prev=Math.max(nums[0],nums[1]); int temp;
        for (int i=2;i<nums.length;i++){
            temp = prev;
            prev = Math.max(nums[i]+pprev,prev);
            pprev=temp;
        }
        return prev;
    }
}
