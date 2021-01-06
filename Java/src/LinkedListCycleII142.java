public class LinkedListCycleII142 {
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean metonce = false;
        int cyclelength = 0;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast && !metonce){
                metonce=true;
            };
            if (slow==fast && cyclelength!=0){
                ListNode headstart = head;
                for (int i=0;i<cyclelength;i++)
                    headstart = headstart.next;
                while (head != headstart){
                    head = head.next;
                    headstart = headstart.next;
                }
                return headstart;
            }
            if (metonce){
                cyclelength++;
            }
        }
        return null;
    }
}
