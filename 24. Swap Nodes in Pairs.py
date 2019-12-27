# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None
    def __str__(self):
        printstr = ""
        while self.next!=None:
            printstr += str(self.val)
            printstr += " -> "
            self = self.next
        printstr += str(self.val)
        return printstr
    
class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        
        dummy = cur = ListNode(0)
        cur.next = head
        while cur.next != None and cur.next.next!= None:
            first = cur.next
            second = cur.next.next
            first.next = second.next
            cur.next=second
            cur.next.next=first
            cur = cur.next.next
        return dummy.next
        
        
test = Solution()

l1 = ListNode(1)
l1.next = ListNode(2)
l1.next.next = ListNode(3)
l1.next.next.next = ListNode(4)
l1.next.next.next.next = ListNode(5)


print(test.swapPairs(l1))