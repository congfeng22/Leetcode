public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null) return;
        ListNode mid = head;
        ListNode end = head;
        while (end.next != null && end.next.next != null) {
            mid = mid.next;
            end = end.next.next;
        }
        ListNode headsecond = mid.next;
        mid.next = null;
        headsecond = reverse(headsecond);

        while (head!=null && headsecond!=null){
            ListNode dummy = head.next;
            ListNode dummy2 = headsecond.next;
            head.next = headsecond;
            headsecond.next=dummy;
            head = dummy;
            headsecond = dummy2;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode dummy = head.next;
        head.next = null;
        ListNode newhead = dummy;
        while (newhead!=null){
            newhead=dummy.next;
            dummy.next = head;
            head = dummy;
            dummy = newhead;
        }
        return head;
    }
    public static void main(String[] args){
        ReorderList143 test = new ReorderList143();
        ListNode a= new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode b = new ListNode(1);
        test.reorderList(a);
        while (a != null){
            System.out.println(a.val);
            a=a.next;
        }
        test.reorderList(b);
        while (b != null){
            System.out.println(b.val);
            b=b.next;
        }
    }
}
