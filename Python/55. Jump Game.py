class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums)==1:
            return True
        lastone = 0
        for i in range(len(nums)-1):
            if i<=lastone:
                lastone = max(lastone,i+nums[i])
            if lastone>= len(nums)-1:
                return True
        return False
test = Solution()
print(test.canJump([0,1,4]))

'''
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        lastone = 0

        pointer = 0
        while lastone<len(nums)-1:
            if pointer+nums[pointer]<=lastone:
                pointer-=1
                if pointer <= 0:
                    return False
            else:
                lastone = pointer+nums[pointer]
                pointer = lastone
        return True
'''