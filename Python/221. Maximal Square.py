def maximalSquare(matrix):
    dp = [[0 for _ in range(len(matrix[0]))] for _ in range(len(matrix))]
    ret = 0
    for i in range(len(matrix)):
        dp[i][0] = int(matrix[i][0])
        if matrix[i][0] == '1':
            ret = 1
    for i in range(len(matrix[0])):
        dp[0][i] = int(matrix[0][i])
        if matrix[0][i] == '1':
            ret = 1
    for i in range(1,len(matrix)):
        for j in range(1,len(matrix[0])):
            if matrix[i][j] == '0':
                dp[i][j] = 0
            else:
                dp[i][j] = min([dp[i-1][j], dp[i][j-1], dp[i-1][j-1]])+1
                ret = max(ret, dp[i][j]**2)
    #print(dp)
    return ret