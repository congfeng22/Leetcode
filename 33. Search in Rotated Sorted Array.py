class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if nums == []:
            return -1
        
        l,r = 0,len(nums)-1
        while l<r:
            if nums[(l+r)//2]>nums[r]:
                l = (l+r+1)//2
            else:
                r = (l+r)//2
        pivot = r
        
        if target > nums[-1]:
            l,r = 0,pivot-1
        else:
            l,r = pivot, len(nums)-1
        while l+1<r:
            if nums[(l+r)//2]>target:
                r = (l+r)//2
            else:
                l = (l+r)//2
        if nums[l] == target:
            return l
        elif nums[r] == target:
            return r
        else:
            return -1
        
    
test = Solution()
print(test.search([1,3],1))