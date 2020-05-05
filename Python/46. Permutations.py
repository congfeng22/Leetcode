class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) == 1:
            return [nums]
        else:
            alllist = []
            for i in range(len(nums)):
                copy = nums[:]
                del copy[i]
                alllist += [[nums[i]] + j for j in Solution.permute(self,copy)]
        return alllist
test = Solution()
print(test.permute([1,2,3]))