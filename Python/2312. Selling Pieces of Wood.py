def sellingWood(m,n,prices):
    prices = {(p[0],p[1]):p[2] for p in prices}
    # dp[i][j] = most value from an i+1 by j+1 wood piece
    dp = [[0 for _ in range(n)] for _ in range(m)]
    for r in range(m):
        for c in range(n):
            res = prices.get((r+1,c+1), 0)
            # all ways to cut it row-wise
            for i in range((r+1)//2):
                res = max(res, dp[i][c] + dp[r-i-1][c])
            for i in range((c+1)//2):
                res = max(res, dp[r][i] + dp[r][c-i-1])
            # print(r,c,res)
            dp[r][c] = res
    # print(dp)
    return dp[m-1][n-1]