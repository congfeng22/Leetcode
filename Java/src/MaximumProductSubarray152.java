public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        int dpplus=nums[0];
        int dpminus=nums[0];
        int ret = nums[0];
        for (int i=1;i<nums.length;i++){
            int temp = dpplus;
            dpplus = Math.max(nums[i],Math.max(nums[i]*dpplus,nums[i]*dpminus));
            dpminus = Math.min(nums[i],Math.min(nums[i]*temp,nums[i]*dpminus));
            ret = Math.max(dpplus,ret);
        }
        return ret;
    }
}
