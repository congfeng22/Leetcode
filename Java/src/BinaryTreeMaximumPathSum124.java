public class BinaryTreeMaximumPathSum124 {
    public int maxPathSum(TreeNode root) {
        int ret = root.val;
        // if max path doesn't contain root
        if (root.left!=null) ret = Math.max(ret,maxPathSum(root.left));
        if (root.right!=null) ret = Math.max(ret,maxPathSum(root.right));
        // if max path contains root
        ret = Math.max(ret,fromroot(root.left)+fromroot(root.right)+root.val);
        return ret;
    }
    public int fromroot(TreeNode root){
        if (root==null) return 0;
        return Math.max(Math.max(root.val+fromroot(root.right),root.val+fromroot(root.left)),0);
    }
}
