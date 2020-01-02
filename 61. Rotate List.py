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
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if head == None:
            return None
        last = head
        length = 1
        while last.next!=None:
            last = last.next
            length+=1
        shifts = k%length
        if shifts == 0:
            return head
        dummy = middle = end = ListNode(0)
        end.next = head
        for i in range(length-shifts):
            end = end.next
            middle = middle.next
        middle = middle.next
        end.next = None
        last.next = head
        dummy.next = middle
        return dummy.next
        
test = Solution()

l1 = ListNode(2)
l1.next = ListNode(4)
l1.next.next = ListNode(3)
l1.next.next.next = ListNode(9)

print(test.rotateRight(l1,4))