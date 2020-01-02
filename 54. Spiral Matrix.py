class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if len(matrix)==0 or len(matrix[0])==0:
            return []
        elif len(matrix) == 1:
            return matrix[0]
        elif len(matrix[0])==1:
            return [i[0] for i in matrix]
        else:
            return matrix[0] + [i[-1] for i in matrix[1:-1]] + matrix[-1][::-1] + [i[0] for i in matrix[-2:0:-1]] + Solution.spiralOrder(self,[i[1:-1] for i in matrix[1:-1]])
            
        
test = Solution()
print(test.spiralOrder([[1,2,3],[4,5,6],[7,8,9]]))