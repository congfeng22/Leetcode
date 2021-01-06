public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        int l=0; int r = nums.length-1;
        while (l<r){
            int mid = (l+r)/2;
            if ((mid==0 || nums[mid-1]<nums[mid]) && (mid == nums.length-1 || nums[mid]>nums[mid+1])) return mid;
            else if (nums[mid]<nums[mid+1]) l=mid+1;
            else r=mid-1;
        }
        return l;
    }
}
