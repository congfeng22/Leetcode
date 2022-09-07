def longestIncreasingPath(matrix):
    cache = {}
    def dfs(matrix,i,j):
        if (i,j) in cache:
            return cache[(i,j)]
        curr = matrix[i][j]
        currmax = 1
        if i>0 and matrix[i-1][j]>curr:
            currmax = max(currmax, dfs(matrix,i-1,j) + 1)
        if i<len(matrix)-1 and matrix[i+1][j]>curr:
            currmax = max(currmax, dfs(matrix,i+1,j) + 1)
        if j>0 and matrix[i][j-1]>curr:
            currmax = max(currmax, dfs(matrix,i,j-1) + 1)
        if j<len(matrix[0])-1 and matrix[i][j+1]>curr:
            currmax = max(currmax, dfs(matrix,i,j+1) + 1)
        cache[(i,j)] = currmax
        return currmax
    ret = 1
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            ret = max(ret,dfs(matrix,i,j))
    #print(cache)
    return ret