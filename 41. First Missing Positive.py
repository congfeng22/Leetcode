class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        for idx in range(n-1,-1,-1):
            if nums[idx]<=0:
                del nums[idx]
        print(nums)
        for i in nums:
            if i<0:
                a = -i
            else:
                a = i
            if a>len(nums):
                continue
            if nums[a-1]>0:
                nums[a-1] *= -1
        for i in range(len(nums)):
            if nums[i]>0:
                return i+1
        return len(nums)+1
    
test = Solution()
print(test.firstMissingPositive([1,2,0,4,1,2]))