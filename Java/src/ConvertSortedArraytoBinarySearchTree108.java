public class ConvertSortedArraytoBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return sortedArrayToBSTidx(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayToBSTidx(int[] nums, int l, int r) {
        if (l==r) return new TreeNode(nums[l]);
        int middle = (l+r)/2;
        TreeNode left = null;
        if (middle != l) left = sortedArrayToBSTidx(nums,l,middle-1);
        TreeNode right = null;
        if (middle != r) right = sortedArrayToBSTidx(nums,middle+1,r);
        return new TreeNode(nums[middle],left,right);
    }
}
