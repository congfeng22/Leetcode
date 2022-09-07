import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        List<Integer> a = new ArrayList<>();
        while (head != null){
            a.add(head.val);
            head=head.next;
        }
        for (int i=0;i<a.size()/2;i++){
            if (!a.get(i).equals(a.get(a.size() - 1 - i))) return false;
        }
        return true;
    }
}
