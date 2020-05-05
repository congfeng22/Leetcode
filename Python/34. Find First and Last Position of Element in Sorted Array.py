class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums ==[]:
            return -1,-1
        l1,l2,r1,r2 = 0,len(nums)-1,0,len(nums)-1

        while l1+1<l2:
            midl = (l1+l2)//2
            if nums[midl]<target:
                l1 = midl
            elif nums[midl]>target:
                l2 = midl-1
            else:
                l2 = midl
        while r1+1<r2:
            midr = (r1+r2)//2
            if nums[midr]<target:
                r1 = midr+1
            elif nums[midr]>target:
                r2 = midr
            else:
                r1 = midr
        if nums[l1] == target:
            l2 = l1
        if nums[r2] == target:
            r1 = r2
        if (nums[l2],nums[r1]) != (target,target):
            return -1,-1
        if nums[l1] == target:
            l2 = l1
        if nums[r2] == target:
            r1 = r2
        return l2,r1
    
test = Solution()
print(test.searchRange([1,2],1))