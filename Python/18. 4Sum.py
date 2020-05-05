class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        quadlist = []
        for idxa,a in enumerate(nums[:-2]):
            if a == nums[idxa-1] and idxa>0:
                continue
            if a>0 and a>target:
                break
            for idxb, b in enumerate(nums[idxa+1:-1]):
                if b == nums[idxa+1+idxb-1] and idxb>0:
                    continue
                l = idxa+1+idxb+1
                r = len(nums)-1
                while l<r:
                    quadsum = a+b+nums[l]+nums[r]
                    if quadsum<target:
                        while l+1<r and nums[l]==nums[l+1]:
                            l+=1
                        l+=1
                    elif quadsum>target:
                        while l+1<r and nums[r]==nums[r-1]:
                            r-=1
                        r-=1
                    else:
                        quadlist.append([a,b,nums[l],nums[r]])
                        while l+1<r and nums[r]==nums[r-1]:
                            r-=1
                        while l+1<r and nums[l]==nums[l+1]:
                            l+=1
                        l+=1
                        r-=1
        return quadlist
    
test = Solution()
print(test.fourSum([-5,-4,-2,-2,-2,-1,0,0,1],-9))