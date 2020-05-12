public class FlattenBinaryTreetoLinkedList114 {
    public void flatten(TreeNode root) {
        if (root==null) return;
        flatten(root.left);
        flatten(root.right);
        if (root.left==null) return;
        bottom(root.left).right=root.right;
        root.right=root.left;
        root.left=null;
    }
    public TreeNode bottom(TreeNode root){
        if (root==null) return null;
        if (root.right==null) return root;
        return bottom(root.right);
    }
}
