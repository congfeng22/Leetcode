class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        nfact = {0:1,1:1,2:2,3:6,4:24,5:120,6:720,7:5040,8:40320,9:362880}
        nlist = [i for i in range(1,n+1)]
        ans = ""
        count = 1
        while nlist!=[]:
            
            front = (k-1)//nfact[n-count] + 1
            ans+=str(nlist[front-1])
            k = (k-1)%nfact[n-count] + 1
            del nlist[front-1]
            count+=1
        return ans
test = Solution()
print(test.getPermutation(4,24))