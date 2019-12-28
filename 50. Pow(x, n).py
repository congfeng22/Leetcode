class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n<0:
            return 1/Solution.myPow(self,x,-n)
        elif n==0:
            return 1
        elif n%2:
            return x*Solution.myPow(self,x,n-1)
        return Solution.myPow(self,x*x,n//2)

test = Solution()
print(test.myPow(2.00000,-2))