import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal145 {
    List<Integer> ret = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return ret;
    }
    public void helper(TreeNode root){
        if (root==null) return;
        helper(root.left);
        helper(root.right);
        ret.add(root.val);
    }
}
