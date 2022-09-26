def smallestRangeII(nums, k):
    nums.sort()
    highestafterchange, lowestbeforechange = -float('infinity'), nums[0]
    score = float('infinity')
    for i in range(len(nums)):
        # print(score, highestafterchange, lowestbeforechange)
        highestafterchange = nums[i]+2*k
        lowestbeforechange = nums[i+1] if i < len(nums)-1 else float('infinity')
        # print(score, highestafterchange, lowestbeforechange)
        score = min(score, max(highestafterchange, nums[-1])-min(lowestbeforechange, nums[0]+2*k))
    return score