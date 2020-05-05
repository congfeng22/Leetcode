class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        prod = 1
        for i in range(min(m-1,n-1)):
            prod *= m+n-2-i
            prod /= (i+1)
        return int(prod)
test = Solution()
print(test.uniquePaths(7,3))