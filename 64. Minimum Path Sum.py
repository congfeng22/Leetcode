class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        for row in range(1,len(grid)):
            grid[row][0] += grid[row-1][0]
        for col in range(1,len(grid[0])):
            grid[0][col] += grid[0][col-1]
        for row in range(1,len(grid)):
            for col in range(1,len(grid[0])):
                grid[row][col] += min(grid[row-1][col],grid[row][col-1])
        return grid[-1][-1]
test = Solution()
print(test.minPathSum([
  [1,3,1],
  [1,5,1],
  [4,2,1]
]))