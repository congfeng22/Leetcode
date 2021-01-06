public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode newhead = null;
        while (head!=null){
            temp = head.next;
            head.next = newhead;
            newhead = head;
            head = temp;
        }
        return newhead;
    }
}
