class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        mindiff = 0
        closesum = 0
        for idx,a in enumerate(nums):
            l,r = idx+1, len(nums)-1
            while l<r:
                tripsum = a + nums[l] + nums[r]
                if mindiff == 0 or mindiff>abs(target-tripsum):
                    mindiff = abs(target-tripsum)
                    closesum = tripsum
                if tripsum<target:
                    while nums[l] == nums[l+1] and l+1<r:
                        l = l+1    
                    l = l+1
                elif tripsum>target:
                    while nums[r] == nums[r-1] and l+1<r:
                        r = r-1
                    r = r-1
                else:
                    return target
        return closesum
                
            
test = Solution()
print(test.threeSumClosest([-3,0,1,2],1))