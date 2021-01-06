import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal144 {
    List<Integer> ret = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return ret;
    }
    public void helper(TreeNode root){
        if (root==null) return;
        ret.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
