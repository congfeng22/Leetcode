public class CountCompleteTreeNodes222 {
    public int countNodes(TreeNode root) {
        return root==null?0:1 + countNodes(root.left) + countNodes(root.right);
    }
}
