def intersection(nums):
    ret = set(nums[0])
    for i in range(1,len(nums)):
        ret = ret.intersection(set(nums[i]))
    return sorted(list(ret))