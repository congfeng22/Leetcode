def maxProfit(k, prices):
    # dp[i][j][k] = max profit with prices[i:], j whole transactions left, k=0 (not holding on a stock) or k=1 (holding on a stock)
    dp = [[[0 for _ in range(2)] for _ in range(k+1)] for _ in range(len(prices)+1)]
    for i in range(len(prices)-1,-1,-1):
        for j in range(1,k+1):
            dp[i][j][0] = max(dp[i+1][j][0], -prices[i]+dp[i+1][j][1])
            dp[i][j][1] = max(dp[i+1][j][1], +prices[i]+dp[i+1][j-1][0])
    #print(dp)
    return dp[0][k][0]