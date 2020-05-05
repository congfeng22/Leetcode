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
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        dummyhead = cur = ListNode(0)
        carry = 0
        while l1!= None or l2!= None:
            if l1 == None:
                l1 = ListNode(0)
            elif l2 == None:
                l2 = ListNode(0)
            total = l1.val + l2.val + carry
            
            if total>9:
                newtotal =  total-10
            else:
                newtotal = total
            cur.next = ListNode(newtotal)
            if total>9:
                carry = 1
            else:
                carry = 0
            l1 = l1.next
            l2 = l2.next
            cur = cur.next
        
        else:
            if carry == 1:
                cur.next = ListNode(carry)
        return dummyhead.next
       
test = Solution()

l1 = ListNode(2)
l1.next = ListNode(4)
l1.next.next = ListNode(3)
l1.next.next.next = ListNode(9)

l2 = ListNode(5)
l2.next = ListNode(6)
l2.next.next = ListNode(7)

print(test.addTwoNumbers(l1,l2))