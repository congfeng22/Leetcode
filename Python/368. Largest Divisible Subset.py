def largestDivisibleSubset(nums):
    cache = {}
    nums.sort()
    def helper(nums, idx):
        # return largest subset of nums given that it must contain nums[idx] and nums[idx] is minimum of the subset
        if idx in cache:
            return cache[idx]
        highest, ret = 1, [nums[idx]]
        for i in range(idx+1, len(nums)):
            if nums[i]%nums[idx] == 0:
                
                ifinclude = helper(nums, i) + [nums[idx]]
                #print(i,idx, ifinclude)
                if highest < len(ifinclude):
                    highest = len(ifinclude)
                    ret = ifinclude
        cache[idx] = ret
        return ret
    ret = []
    for i in range(len(nums)):
        a = helper(nums, i)
        if len(ret)<len(a):
            ret = a
    return ret