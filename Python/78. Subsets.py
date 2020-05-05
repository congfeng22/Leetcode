class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        rlist = []
        if nums == []:
            return [[]]
        rlist = [[nums[-1]] + i for i in Solution.subsets(self,nums[:-1])] + [i for i in Solution.subsets(self,nums[:-1])]
        return rlist
test = Solution()
print(test.subsets([1,2,3]))