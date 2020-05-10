import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null) return levels;
        for (int i=0;i<height(root);i++){
            levels.add(new ArrayList<>());
        }
        traversaloddskip(root,1);
        traversalevenskip(root.right,2);
        traversalevenskip(root.left,2);
        return levels;
    }
    public void traversaloddskip (TreeNode root, int lvl){
        if (root==null) return;
        levels.get(lvl-1).add(root.val);
        if (root.left!=null){
            traversaloddskip(root.left.left,lvl+2);
            traversaloddskip(root.left.right,lvl+2);
        }
        if (root.right!=null){
            traversaloddskip(root.right.left,lvl+2);
            traversaloddskip(root.right.right,lvl+2);
        }
    }
    public void traversalevenskip (TreeNode root, int lvl){
        if (root==null) return;
        levels.get(lvl-1).add(root.val);
        if (root.right!=null){
            traversalevenskip(root.right.right,lvl+2);
            traversalevenskip(root.right.left,lvl+2);
        }
        if (root.left!=null){
            traversalevenskip(root.left.right,lvl+2);
            traversalevenskip(root.left.left,lvl+2);
        }
    }
    public int height(TreeNode root){
        if (root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}
