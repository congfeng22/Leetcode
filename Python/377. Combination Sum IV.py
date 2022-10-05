def combinationSum4(nums, target):
    dp = [1]
    # dp[i] = number of possible combinations to add to i
    for i in range(1,target+1):
        a = 0
        for j in nums:
            if j <=i:
                a += dp[i-j]
        dp.append(a)
    return dp[-1]