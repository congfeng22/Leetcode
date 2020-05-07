import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists23 {
    public static class The_Comparator implements Comparator<ListNode> {
        public int compare(ListNode l1, ListNode l2){ return l1.val-l2.val; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new The_Comparator());
        for (ListNode l : lists){
            if (l!=null) pq.add(l);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (pq.size() > 0){
            tail.next = pq.remove();
            tail = tail.next;
            if (tail.next !=null) pq.add(tail.next);
        }
        return dummy.next;
    }
    public static void main(String[] args){
        MergekSortedLists23 test = new MergekSortedLists23();
        ListNode l1 = new ListNode(1,new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1,new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2,new ListNode(6));
        ListNode[] lists = {l1,l2,l3};
        System.out.println(test.mergeKLists(lists));
    }
}
