public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0) return null;
        return buildTreeidx(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode buildTreeidx(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        int i=0;
        while (inorder[l2+i]!=preorder[l1]) i++;
        TreeNode left = null;
        if (i!=0){
            left = buildTreeidx(preorder,l1+1,l1+i,inorder,l2,l2+i-1);
        }
        TreeNode right = null;
        if (i!=r2-l2){
            right = buildTreeidx(preorder,l1+i+1,r1,inorder,l2+i+1,r2);
        }
        return new TreeNode(preorder[l1],left,right);
    }
}
