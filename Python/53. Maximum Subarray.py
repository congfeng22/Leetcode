class Solution(object):
    
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxsum = nums[0]
        sumendinghere = nums[0]
        for i in range(1,len(nums)):
            sumendinghere = max(nums[i],sumendinghere + nums[i])
            maxsum = max(maxsum, sumendinghere)
        return maxsum
test = Solution()
print(test.maxSubArray([1,2,-10,3,4,5]))