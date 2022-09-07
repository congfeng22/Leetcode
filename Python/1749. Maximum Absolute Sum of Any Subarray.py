def maxAbsoluteSum(nums):
    ret = 0
    # find max subarray sum
    l,r = 0, 0
    sumSoFar = nums[0]
    ret = sumSoFar
    while r<len(nums)-1:
        if sumSoFar < 0:
            l, r = r+1, r+1
            sumSoFar = nums[r]
            ret = max(ret, sumSoFar)
        else:
            r += 1
            sumSoFar += nums[r]
            ret = max(ret, sumSoFar)
    # find min subarray sum
    l,r = 0, 0
    sumSoFar = -nums[0]
    ret = max(ret, sumSoFar)
    while r<len(nums)-1:
        if sumSoFar < 0:
            l, r = r+1, r+1
            sumSoFar = -nums[r]
            ret = max(ret, sumSoFar)
        else:
            r += 1
            sumSoFar += -nums[r]
            ret = max(ret, sumSoFar)
    return ret