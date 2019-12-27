class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if target in nums:
            return nums.index(target)
        else:
            for i in nums:
                if target<i:
                    return nums.index(i)
            return len(nums)
test = Solution()
print(test.searchInsert([1,3,5,6],7))