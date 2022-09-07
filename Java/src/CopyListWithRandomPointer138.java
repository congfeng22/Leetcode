import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer138 {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node dummy = head;
        ArrayList<Node> nodelist = new ArrayList<>();
        int idx = 0;
        while (head != null){
            nodelist.add(new Node(head.val));
            head.val += 10000 + idx*20001;
            head = head.next;
            idx ++;
        }
        head = dummy;
        idx = 0;
        while (head != null){
            if (head.random == null){
                nodelist.get(idx).random = null;
            } else {
                nodelist.get(idx).random = nodelist.get(head.random.val/20001);
            }
            if (head.next != null){
                nodelist.get(idx).next = nodelist.get(idx+1);
            }
            idx ++;
            head = head.next;
        }
        return nodelist.get(0);
    }
}
