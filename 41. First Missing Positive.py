class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxnum = 0
        powersum = 1
        for i in nums:
            if i>maxnum:
                maxnum = i
            if i>0:
                powersum += 2**i
        binstr = bin(2**(maxnum+1)-1-powersum)
        for i in range(2,len(binstr)):
            if binstr[-i] == '1':
                return i-1
        return maxnum+1
        
test = Solution()
print(test.firstMissingPositive([3,5,4,2,1]))