public class RemoveDuplicatesfromSortedListII82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next == null) return head;
        if (head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
            return head;
        }
        while (head.next!=null && head.val == head.next.val){
            head = head.next;
        }
        return deleteDuplicates(head.next);
    }
    public static void main(String[] args){
        RemoveDuplicatesfromSortedListII82 test = new RemoveDuplicatesfromSortedListII82();
        ListNode head = new ListNode(3,new ListNode(3,new ListNode(4, new ListNode(4, new ListNode(5)))));
        head = test.deleteDuplicates(head);
        while (head != null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
