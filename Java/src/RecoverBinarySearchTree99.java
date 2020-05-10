import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree99 {
    List<TreeNode> traversedNode = new ArrayList<>();
    List<Integer> traversedVal = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        traversal(root);
        int swapped1val=0;
        int swapped2val=0;
        int drops = 0;
        for (int i=0;i<traversedVal.size()-1;i++){
            if (traversedVal.get(i)>traversedVal.get(i+1)){
                drops++;
                if (drops == 1) {
                    swapped1val=traversedVal.get(i);
                    swapped2val=traversedVal.get(i+1);
                }
                else if (drops == 2) swapped2val=traversedVal.get(i+1);
            }
        }
        swap(root,swapped1val,swapped2val);
    }
    public void swap(TreeNode root, int swapped1val, int swapped2val){
        if (root==null) return;
        if (root.val == swapped1val) root.val = swapped2val;
        else if (root.val == swapped2val) root.val = swapped1val;
        swap(root.left,swapped1val,swapped2val);
        swap(root.right,swapped1val,swapped2val);
    }
    public void traversal (TreeNode root){
        if (root==null) return;
        traversal(root.left);
        traversedNode.add(root);
        traversedVal.add(root.val);
        traversal(root.right);
    }
}
