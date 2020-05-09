class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        if nums == []:
            return 0
        for i in nums[::-1]:
            if i == val:
                nums.remove(i)
        return len(nums)
