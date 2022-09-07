def findCircleNum(isConnected):
    ret = 0
    visited = set()
    def dfs(isConnected, i):
        #visit unvisited nodes from i
        visited.add(i)
        for j in range(len(isConnected)):
            if isConnected[i][j] and j not in visited:
                dfs(isConnected, j)
        return
    for n in range(len(isConnected)):
        if n not in visited:
            dfs(isConnected, n)
            ret += 1
    return ret