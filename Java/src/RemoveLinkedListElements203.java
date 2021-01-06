public class RemoveLinkedListElements203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return null;
        ListNode dummy = new ListNode(0,head);
        head = dummy;
        while (head.next!=null){
            if (head.next.val==val){
                head.next=head.next.next;
            }
            else head=head.next;
        }
        return dummy.next;
    }
}
