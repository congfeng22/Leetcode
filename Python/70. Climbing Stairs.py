class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        a = 0
        b = 1
        for i in range(n):
            a,b = b,a+b
        return b
test = Solution()
for i in range(5):
    print(test.climbStairs(i))