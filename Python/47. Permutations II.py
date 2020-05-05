class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        newnums = sorted(nums)
        if len(newnums) == 1:
            return [newnums]
        else:
            alllist = []
            for i in range(len(newnums)):
                if i>0 and newnums[i]==newnums[i-1]:
                    continue
                copy = newnums[:]
                del copy[i]
                alllist += [[newnums[i]] + j for j in Solution.permuteUnique(self,copy)]
        return alllist

test = Solution()
print(test.permuteUnique([1,1,4]))