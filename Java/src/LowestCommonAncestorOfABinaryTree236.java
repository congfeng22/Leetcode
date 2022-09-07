import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p==root || q==root) return root;
        boolean pin = isin(root.left,p);
        boolean qin = isin(root.left,q);
        if (pin&&qin) return lowestCommonAncestor(root.left,p,q);
        if (!pin && !qin) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
    public boolean isin(TreeNode root, TreeNode n){
        if (root==null) return false;
        if (root==n) return true;
        return isin(root.left,n) || isin(root.right,n);
    }
    public static void main(String[] args){
        LowestCommonAncestorOfABinaryTree236 test = new LowestCommonAncestorOfABinaryTree236();
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(5,new TreeNode(6),new TreeNode(2, new TreeNode(7), a));
        System.out.println(test.isin(b,b));
        System.out.println(test.isin(b,a));
    }
}
