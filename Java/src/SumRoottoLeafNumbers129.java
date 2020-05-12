public class SumRoottoLeafNumbers129 {
    int ret = 0;
    public int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        sumNumbersb(root,0);
        return ret;
    }
    public void sumNumbersb(TreeNode root, int path){
        if (root.left==null && root.right==null){
            ret += path*10+root.val;
            return;
        }
        if (root.left!=null) sumNumbersb(root.left,path*10+root.val);
        if (root.right!=null) sumNumbersb(root.right,path*10+root.val);
    }
}
