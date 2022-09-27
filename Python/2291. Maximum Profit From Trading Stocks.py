def maximumProfit(present, future, budget):
    # dp[i][j] = max profit for stocks [i:] with j budget
    # base cases are i = len(present) and j = 0
    # return dp[0][budget]
    dp = [[0 for _ in range(budget+1)] for _ in range(len(present)+1)]
    for i in range(len(present)-1,-1,-1):
        for j in range(1,budget+1):
            if j-present[i] >= 0:
                dp[i][j] = max(dp[i+1][j], future[i]-present[i]+dp[i+1][j-present[i]])
            else: 
                dp[i][j] = dp[i+1][j]
    #print(dp)
    return dp[0][budget]

print(maximumProfit([3,3,12],[0,3,15], 10))