public class ReverseNodesinkGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // placeholder
        ListNode newhead = head;
        // if list too small, just return it
        int count = 0;
        while(head!= null && count<k){
            head = head.next;
            count++;
        }
        if (count<k) return newhead;
        // reverse leftovers
        head = reverseKGroup(head,k);

        ListNode newtail = newhead;
        while (count>0){
            count--;
            newhead = newhead.next;
            newtail.next = head;
            head = newtail;
            newtail = newhead;
        }
        return head;
    }
}
