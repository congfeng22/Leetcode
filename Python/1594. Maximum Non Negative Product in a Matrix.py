def maxProductPath(grid):
    dp = [[(0,0) for _ in range(len(grid[0]))] for _ in range(len(grid))]
    dp[0][0] = (max(-1,grid[0][0]), min(1,grid[0][0]))
    for i in range(1,len(grid)):
        if grid[i][0] > 0:
            dp[i][0] = (dp[i-1][0][0]*grid[i][0], dp[i-1][0][1]*grid[i][0])
        elif grid[i][0] < 0:
            dp[i][0] = (dp[i-1][0][1]*grid[i][0], dp[i-1][0][0]*grid[i][0])
    for i in range(1,len(grid[0])):
        if grid[0][i] > 0:
            dp[0][i] = (dp[0][i-1][0]*grid[0][i], dp[0][i-1][1]*grid[0][i])
        elif grid[0][i] < 0:
            dp[0][i] = (dp[0][i-1][1]*grid[0][i], dp[0][i-1][0]*grid[0][i])
    for i in range(1,len(grid)):
        for j in range(1,len(grid[0])):
            if grid[i][j] == 0:
                dp[i][j] = (0,0)
            elif grid[i][j] > 0:
                dp[i][j] = (max(dp[i-1][j][0], dp[i][j-1][0]) * grid[i][j], min(dp[i-1][j][1], dp[i][j-1][1]) * grid[i][j])
            else:
                dp[i][j] = (min(dp[i-1][j][1], dp[i][j-1][1]) * grid[i][j], max(dp[i-1][j][0], dp[i][j-1][0]) * grid[i][j])
    #print(dp)
    return dp[len(grid)-1][len(grid[0])-1][0] % (10**9+7) if dp[len(grid)-1][len(grid[0])-1][0] > -1 else -1