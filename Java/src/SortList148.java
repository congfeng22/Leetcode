public class SortList148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        //System.out.println(head.val);
        //System.out.println(head2.val);
        head2 = sortList(head2);
        head = sortList(head);
        // merge
        ListNode curr = dummy;
        while (head != null && head2 != null){
            if (head.val < head2.val){
                curr.next = head;
                head = head.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if (head == null){
            curr.next = head2;
        } else {
            curr.next = head;
        }
        return dummy.next;
    }
}
