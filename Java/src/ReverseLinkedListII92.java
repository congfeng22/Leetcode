import java.util.List;

public class ReverseLinkedListII92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n) return head;
        // head = 0 in front of list, p1 = right before reversal, prev, curr, next
        head = new ListNode(0,head);
        ListNode p1 = head;
        for (int i=0;i<m-1;i++) {
            p1 = p1.next;
        }
        ListNode prev = p1.next; ListNode curr = prev.next; ListNode next= curr.next;
        for (int i=0;i<n-m;i++){
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next!=null) next = next.next;
        }
        p1.next.next = curr;
        p1.next = prev;
        return head.next;
    }
}
