import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new ArrayList<>();
        if (n==0){
            return ret;
        }
        // root is from 1 to n
        for (int i=1;i<=n;i++){
            List<TreeNode> left = generateTrees(i-1);
            if (left.size()==0) left.add(null);
            List<TreeNode> right = generateTrees(n-i);
            if (right.size()==0) right.add(null);
            for (TreeNode r:right){
                TreeNode copyr = copy(r);
                addn(copyr,i);
                for (TreeNode l:left){
                    ret.add(new TreeNode(i,l,copyr));
                }
            }
        }
        return ret;
    }
    public TreeNode copy(TreeNode root){
        if (root==null) return null;
        return new TreeNode(root.val, copy(root.left),copy(root.right));
    }
    // add n to every node in root
    public void addn(TreeNode root, int n){
        if (root==null) return;
        root.val +=n;
        addn(root.left,n);
        addn(root.right,n);
    }
}