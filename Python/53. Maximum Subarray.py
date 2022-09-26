def maxSubArray(nums):
    l,r = 0,0
    currsum = nums[0]
    ret = nums[0]
    while r < len(nums)-1:
        if currsum >= 0:
            r += 1
            currsum += nums[r]
            ret = max(ret, currsum)
        else:
            l,r = r+1,r+1
            currsum = nums[l]
            ret = max(ret, currsum)
    return ret