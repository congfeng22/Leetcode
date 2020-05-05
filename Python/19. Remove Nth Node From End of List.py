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
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dummyhead = follower1 = follower2 = leader = ListNode(0)
        count = 0
        leader.next = head
        while count < n+1:
            leader = leader.next
            count+=1
        while leader != None:
            leader = leader.next
            follower1 = follower1.next
            follower2 = follower2.next
        follower2 = follower2.next.next
        follower1.next = follower2
        dummyhead = dummyhead.next
        return dummyhead

test = Solution()

l1 = ListNode(1)
l1.next = ListNode(2)
l1.next.next = ListNode(3)
l1.next.next.next = ListNode(4)
l1.next.next.next.next = ListNode(5)


print(test.removeNthFromEnd(l1,2))