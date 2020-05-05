class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        if k==1:
            return [[i] for i in range(1,n+1)]
        rlist = []
        for i in range(n,k-1,-1):
            rlist += [[i]+j for j in Solution.combine(self,i-1,k-1)]
        return rlist
test = Solution()
print(test.combine(4,2))