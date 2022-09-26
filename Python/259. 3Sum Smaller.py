def threeSumSmaller(nums, target):
    nums.sort()
    ret = 0
    for i in range(len(nums)-2):
        l,r = i+1, len(nums)-1
        while l<r:
            if nums[l]+nums[r]+nums[i] < target:
                ret += r-l
                l += 1
            else:
                r -= 1
    return ret