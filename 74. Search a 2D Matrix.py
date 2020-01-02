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
            mid = (top+down)//2
            if target>=matrix[mid][0]:
                top = mid
            else:
                down = mid
        while left<right-1:
            mid = (left+right)//2
            if target>=matrix[top][mid]:
                left = mid
            else:
                right = mid
        if matrix[top][left]==target:
            return True
        return False
test = Solution()
print(test.searchMatrix([[1, 3, 5, 7],[10, 11, 16, 20],[23, 30, 34, 50]],10))