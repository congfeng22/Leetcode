class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        if obstacleGrid[0][0]==1 or obstacleGrid[-1][-1]==1:
            return 0
        
        obstacleGrid[0][0]=1
        for row in range(1,len(obstacleGrid)):
            if obstacleGrid[row][0]==0:
                obstacleGrid[row][0] = obstacleGrid[row-1][0]
            else:
                obstacleGrid[row][0]=0
        for col in range(1,len(obstacleGrid[0])):
            if obstacleGrid[0][col]==0:
                obstacleGrid[0][col] = obstacleGrid[0][col-1]
            else:
                obstacleGrid[0][col]=0
        for row in range(1,len(obstacleGrid)):
            for col in range(1,len(obstacleGrid[0])):
                if obstacleGrid[row][col]==1:
                    obstacleGrid[row][col]=0
                else:
                    obstacleGrid[row][col]=obstacleGrid[row-1][col]+obstacleGrid[row][col-1]
        return obstacleGrid[-1][-1]
test = Solution()
print(test.uniquePathsWithObstacles([
  [0,0,0],
  [0,1,0],
  [0,0,0]
]))