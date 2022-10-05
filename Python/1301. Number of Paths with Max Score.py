def pathsWithMaxScore(board):
    # dp[i][j] = (a,b). a = max sum collectable from i,j (excl i,j) to 0,0
    # b = # ways to get that sum
    # want dp[m-1][n-1]
    board[0] = "0"+board[0][1:]
    m,n = len(board), len(board[0])
    dp = [[[0,0] for _ in range(n)] for _ in range(m)]
    dp[0][0] = [0,1]
    for i in range(1,m):
        # can only go up
        if board[i-1][0] == 'X' or dp[i-1][0] == [0,0]:
            dp[i][0] = [0,0]
        else:
            dp[i][0] = [dp[i-1][0][0]+int(board[i-1][0]), dp[i-1][0][1]]
    for j in range(1,n):
        # can only go left
        if board[0][j-1] == 'X' or dp[0][j-1] == [0,0]:
            dp[0][j] = [0,0]
        else:
            dp[0][j] = [dp[0][j-1][0]+int(board[0][j-1]), dp[0][j-1][1]]
    for i in range(1,m):
        for j in range(1,n):
            if board[i][j] == 'X':
                dp[i][j] = [0,0]
                continue
            res = 0
            paths = 0
            # try going up
            if board[i-1][j] != 'X' and dp[i-1][j] != [0,0]:
                res = max(res, dp[i-1][j][0]+int(board[i-1][j]))
                paths = dp[i-1][j][1]
            # try going left
            if board[i][j-1] != 'X' and dp[i][j-1] != [0,0]:
                if res == dp[i][j-1][0]+int(board[i][j-1]):
                    paths += dp[i][j-1][1]
                elif res < dp[i][j-1][0]+int(board[i][j-1]):
                    res = dp[i][j-1][0]+int(board[i][j-1])
                    paths = dp[i][j-1][1]
            # try going upleft
            if board[i-1][j-1] != 'X' and dp[i-1][j-1] != [0,0]:
                if res == dp[i-1][j-1][0]+int(board[i-1][j-1]):
                    paths += dp[i-1][j-1][1]
                elif res < dp[i-1][j-1][0]+int(board[i-1][j-1]):
                    res = dp[i-1][j-1][0]+int(board[i-1][j-1])
                    paths = dp[i-1][j-1][1]
            dp[i][j] = [res, paths%(10**9+7)]
    return dp[-1][-1]
