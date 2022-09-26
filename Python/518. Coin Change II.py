def change(amount, coins):
    dp = [[0 for _ in range(len(coins)+1)] for _ in range(amount+1)]
    # dp[i][j] = # combinations to make up i using first j coins
    for i in range(len(coins)+1):
        dp[0][i] = 1
    for i in range(1,amount+1):
        for j in range(1,len(coins)+1):
            if i >= coins[j-1]:
                dp[i][j] = dp[i][j-1] + dp[i-coins[j-1]][j]
            else:
                dp[i][j] = dp[i][j-1]
    return dp[-1][-1]