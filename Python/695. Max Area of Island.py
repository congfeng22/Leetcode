def maxAreaOfIsland(grid):
    maxarea = 0
    def dfs(grid,i,j):
        if i<0 or i >= len(grid) or j<0 or j>=len(grid[0]) or grid[i][j] == 0:
            return 0
        grid[i][j] = 0
        return 1 + dfs(grid, i+1, j)+ dfs(grid, i-1, j)+ dfs(grid, i, j+1) + dfs(grid, i, j-1)
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == 1:
                maxarea = max(maxarea, dfs(grid,i,j))
    return maxarea