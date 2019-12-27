class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        pdivisor = abs(divisor)
        pdividend = abs(dividend)
        count = 0
        while pdividend>=pdivisor:
            x=0
            while pdividend >= (pdivisor<<(x+1)):
                x+=1
            pdividend -= pdivisor<<x
            count+=(1<<x)
        if (divisor>0)!=(dividend>=0):
            count = -count
        return min(count,2**31-1)
test = Solution()
print(test.divide(-100,-3))