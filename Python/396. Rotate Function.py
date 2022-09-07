def maxRotateFunction(nums):
    ret = 0
    asum = 0
    for i in range(len(nums)):
        ret += i*nums[i]
        asum += nums[i]
    temp = ret
    for rot in range(1,len(nums)):
        # -n from index -rot, +1 to every index
        temp = temp+asum-nums[-rot]*len(nums)
        ret = max(ret, temp)
        
    return ret