public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {
        if (head==null || head.next == null) return head;
        ListNode checknext = head;
        head = new ListNode(0,head);
        ListNode lastbig = head;
        ListNode lastsmall = head;
        while (checknext != null){
            if (checknext.val>= x) {
                checknext = checknext.next;
                lastbig = lastbig.next;
            } else if (lastbig==lastsmall){
                checknext = checknext.next;
                lastbig=lastbig.next;
                lastsmall = lastsmall.next;
            } else{
                lastbig.next = checknext.next;
                checknext.next = lastsmall.next;
                lastsmall.next = checknext;
                lastsmall = lastsmall.next;
                checknext = lastbig.next;
            }
        }
        return head.next;
    }
    public static void main(String[] args){
        PartitionList86 test = new PartitionList86();
        ListNode t = new ListNode(1,new ListNode(4,new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        int x = 3;
        t = test.partition(t,x);
        while (t != null){
            System.out.println(t.val);
            t=t.next;
        }
    }
}
