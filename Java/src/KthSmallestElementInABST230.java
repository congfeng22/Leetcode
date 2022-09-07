import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST230 {
    List<Integer> preorder = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        pre(root);
        return preorder.get(k-1);
    }
    public void pre(TreeNode root){
        if (root==null) return;
        if (root.left!=null){
            pre(root.left);
        }
        preorder.add(root.val);
        if (root.right!=null) {
            pre(root.right);
        }
        return;
    }
}
