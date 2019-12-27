class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        
        #1248 -> 1284 -> 1428 -> 1482 -> 1824 -> 1842 -> 2148
        length = len(nums)
        first = None
        for i in range(length-1):
            if nums[length-i-2]<nums[length-i-1]:
                first = nums[length-i-2]
                firstindex = length-i-2
                break
        if first == None:
            for i in range((length+1)//2):
                start = nums[i]
                end = nums[length-i-1]
                nums[i], nums[length-i-1] = end, start
        else:
            secondindex=length-1
            for j in range(firstindex,length-1):
                if nums[j+1]<=first:        
                    secondindex=j
                    break
            second = nums[secondindex]
            nums[firstindex], nums[secondindex] = second, first
            for i in range((length-firstindex)//2):
                start = nums[firstindex+1+i]
                end = nums[length-i-1]
                nums[firstindex+1+i], nums[length-i-1] = end, start
test = Solution()
test.nextPermutation([1,1,5,1,1])