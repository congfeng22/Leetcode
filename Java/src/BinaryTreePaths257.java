import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
    List<String> ret = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null) return ret;
        StringBuilder s = new StringBuilder();
        s.append(root.val);
        if (root.left==null && root.right==null) ret.add(s.toString());
        else{
            if (root.left!=null) helper(root.left,new StringBuilder(s));
            if (root.right!=null) helper(root.right,new StringBuilder(s));
        }
        return ret;
    }
    public void helper(TreeNode root,StringBuilder s){
        s.append("->");
        s.append(root.val);
        if (root.left==null && root.right==null) ret.add(s.toString());
        else{
            if (root.left!=null) helper(root.left,new StringBuilder(s));
            if (root.right!=null) helper(root.right,new StringBuilder(s));
        }

    }
}
