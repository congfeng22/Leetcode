import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        traversal(root,0);
        return levels;
    }
    public void traversal (TreeNode root, int lvl){
        if (root==null) return;
        if (levels.size()<lvl+1) levels.add(new ArrayList<>());
        levels.get(lvl).add(root.val);
        traversal(root.left,lvl+1);
        traversal(root.right,lvl+1);
    }
}
