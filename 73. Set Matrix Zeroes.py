class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        donerows = []
        donecols = []
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col]==0:
                    if row not in donerows:
                        donerows += [row]
                    if col not in donecols:
                        donecols += [col]
        print(donerows,donecols)
        for row in donerows:
            for col in range(len(matrix[0])):
                matrix[row][col]=0
        for row in matrix:
            for col in donecols:
                row[col] = 0
            
        return matrix
test = Solution()
print(test.setZeroes([
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]))