import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII107 {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        traversal(root,0);
        List<Integer> temp;
        for (int i=0;i<levels.size()/2;i++){
            temp = levels.get(i);
            levels.set(i,levels.get(levels.size()-1-i));
            levels.set(levels.size()-1-i,temp);
        }
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
