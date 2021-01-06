import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root==null) return ret;
        Queue<TreeNode> help = new LinkedList<>();
        help.add(root);
        TreeNode temp;
        while (!help.isEmpty()){
            int origsize = help.size();
            while (origsize!=0){
                temp = help.remove();
                if (temp.left!=null) help.add(temp.left);
                if (temp.right!=null) help.add(temp.right);
                if (origsize==1) ret.add(temp.val);
                origsize--;
            }
        }
        return ret;
    }
}
