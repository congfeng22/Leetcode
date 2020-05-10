public class ValidBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        boolean ret = true;
        if (root.left!=null) ret = ret && (root.val>max(root.left)) && isValidBST(root.left);
        if (root.right!=null) ret = ret && (root.val<min(root.right)) && isValidBST(root.right);
        return ret;
    }
    public int min (TreeNode root){
        int ret = root.val;
        if (root.left != null) ret = Math.min(ret,min(root.left));
        if (root.right != null) ret = Math.min(ret,min(root.right));
        return ret;
    }
    public int max (TreeNode root){
        int ret = root.val;
        if (root.left != null) ret = Math.max(ret,max(root.left));
        if (root.right != null) ret = Math.max(ret,max(root.right));
        return ret;
    }
}