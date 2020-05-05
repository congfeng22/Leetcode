class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix)==0 or len(matrix[0])==0:
            return False
        top,down,left,right = 0,len(matrix),0,len(matrix[0])
        while top<down-1:
            if target>=matrix[(top+down)//2][0]:
                top = (top+down)//2
            else:
                down = (top+down)//2
        while left<right-1:
            if target>=matrix[top][(left+right)//2]:
                left = (left+right)//2
            else:
                right = (left+right)//2
        if matrix[top][left]==target:
            return True
        return False
test = Solution()
print(test.searchMatrix([[1, 3, 5, 7],[10, 11, 16, 20],[23, 30, 34, 50]],10))