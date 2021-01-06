public class HouseRobberII213 {
    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        else if (nums.length==1) return nums[0];
        else if (nums.length==2) return Math.max(nums[0],nums[1]);
        else if (nums.length==3) return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        else if (nums.length==4) return Math.max(nums[0]+nums[2],nums[1]+nums[3]);
        int pprev =nums[0]; int prev=Math.max(nums[0],nums[1]); int temp;
        int missing1pprev = nums[1]; int missing1prev = Math.max(nums[1],nums[2]); int missing1temp;
        for (int i=2;i<nums.length-1;i++){
            temp = prev;
            prev = Math.max(nums[i]+pprev,prev);
            pprev=temp;
            if (i>2 && i<nums.length-2){
                missing1temp = missing1prev;
                missing1prev = Math.max(nums[i]+missing1pprev,missing1prev);
                missing1pprev=missing1temp;
            }
        }
        int ret = Math.max(missing1prev+nums[nums.length-1],prev);
        return ret;
    }
}
