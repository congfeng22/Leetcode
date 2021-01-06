public class MinimumSizeSubarraySum209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length==0) return 0;
        int l=0; int r=0; int minsize = Integer.MAX_VALUE; int sum = nums[0];
        while (r<nums.length){
            if (sum<s) {
                if (r==nums.length-1) break;
                r++;
                sum+=nums[r];
            }
            else {
                minsize = Math.min(minsize,r-l+1);
                sum-= nums[l];
                l++;
            }
        }
        if (minsize==Integer.MAX_VALUE) return 0;
        return minsize;
    }
}
