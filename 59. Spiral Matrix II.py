class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        rmatrix = []
        for i in range(n):
            rmatrix.append([])
            for j in range(n):
                rmatrix[i].append(0)
        rmatrix[0][0]=1
        row = 0
        col = 1
        for i in range(2,n**2+1):
            rmatrix[row][col]=i
            if row<=col+1 and col+1<=n-row-1:
                col+=1
            elif n-col<=row+1 and row+1<=col:
                row+=1
            elif n-row-1<=col-1 and col-1<=row-1:
                col-=1
            else:
                row-=1
        return rmatrix
test = Solution()
print(test.generateMatrix(4))