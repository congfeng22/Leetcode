public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        return (lh-rh<=1) && (lh-rh>=-1) && isBalanced(root.left)&& isBalanced(root.right);
    }
    public int height(TreeNode root){
        if (root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}
