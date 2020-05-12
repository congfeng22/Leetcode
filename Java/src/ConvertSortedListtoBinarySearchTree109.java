public class ConvertSortedListtoBinarySearchTree109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int n = len(head);
        if (n==1) return new TreeNode(head.val);
        int middle = n/2;
        ListNode head2 = head;
        for (int i=0;i<middle-1;i++){
            head2 = head2.next;
        }
        ListNode sechead = head2.next.next;
        int root = head2.next.val;
        head2.next = null;
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(sechead);
        return new TreeNode(root,left,right);
    }
    public int len(ListNode head){
        if (head==null) return 0;
        return 1+len(head.next);
    }
}
