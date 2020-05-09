class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == []:
            return 0
        temp = nums[0]
        for i in nums[1:]:
            if i == temp:
                nums.remove(i)
            temp = i
        return len(nums)
