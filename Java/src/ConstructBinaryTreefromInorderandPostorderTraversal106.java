public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder: left, val, right
        // postorder: left, right, val
        if (inorder.length==0) return null;
        return buildTreeidx(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode buildTreeidx(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2){
        int i=0;
        while (inorder[l1+i]!=postorder[r2]) i++;
        TreeNode left = null;
        if (i!=0){
            left = buildTreeidx(inorder,l1,l1+i-1,postorder,l2,l2+i-1);
        }
        TreeNode right = null;
        if (i!=r1-l1){
            right = buildTreeidx(inorder,l1+i+1,r1,postorder,l2+i,r2-1);
        }
        return new TreeNode(postorder[r2],left,right);
    }
}
