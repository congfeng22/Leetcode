class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==1 or len(nums)==2:
            return len(nums)
        behind = 1
        repeat = False
        for i in range(2,len(nums)):
            if nums[behind] == nums[behind-1]:
                repeat = True
            else:
                repeat = False
            if nums[i] == nums[behind]:
                if repeat == True:
                    continue
                else:
                    repeat = True
            else:
                repeat = False
            nums[i], nums[behind+1] = nums[behind+1],nums[i]
            behind += 1
        return behind+1
                
            
test = Solution()
print(test.removeDuplicates([1,1,1,1,2,2,2,3]))