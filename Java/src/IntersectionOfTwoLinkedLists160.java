public class IntersectionOfTwoLinkedLists160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1=0; int len2=0;
        ListNode dum1 = headA; ListNode dum2 = headB;
        while (dum1 != null){
            len1++;
            dum1=dum1.next;
        }
        while (dum2 != null){
            len2++;
            dum2=dum2.next;
        }
        if (len1>len2){
            while (len1 != len2){
                headA=headA.next;
                len2++;
            }
        } else {
            while (len2 != len1){
                headB=headB.next;
                len1++;
            }
        }
        while (headA != headB){
            headA=headA.next;
            headB=headB.next;
            if (headA==null || headB==null) return null;
        }
        return headA;
    }
}
