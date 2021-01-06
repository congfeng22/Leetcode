public class FindMinimumInRotatedSortedArray153 {
    public int findMin(int[] nums) {
        return findMin(nums,0,nums.length);
    }
    public int findMin(int[] nums, int l, int r){
        if (l>=r) return nums[l];
        if (nums[l]<nums[r]) return nums[l];
        int mid=(r+l)/2;
        if (nums[mid]>nums[l]) return findMin(nums,mid+1,r);
        else if (nums[mid]<nums[l]) return findMin(nums,l,mid);
        else return nums[r];
    }
}
