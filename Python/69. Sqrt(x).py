class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 1:
            return x
        l,r = 0,x
        while l<r-1:
            mid = (l+r)//2
            if mid*mid>x:
                r=mid
            elif mid*mid<x:
                l=mid
            else:
                return mid
        return l
test = Solution()
print(test.mySqrt(4))