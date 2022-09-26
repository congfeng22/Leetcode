def numIslands(grid):
    def dfs(grid,i,j):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]):
            return
        if grid[i][j] == '0':
            return
        grid[i][j] = '0'
        dx = [1,0,-1,0]
        dy = [0,1,0,-1]
        for k in range(4):
            dfs(grid, i+dx[k], j+dy[k])
        return
    
    ret = 0
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == '1':
                ret += 1
                dfs(grid,i,j)
    return ret