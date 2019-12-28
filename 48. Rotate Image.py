class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        for layer in range((len(matrix)+1)//2):
            for entry in range(len(matrix)-2*layer-1):
                matrix[layer][layer+entry], matrix[layer+entry][-1-layer], matrix[-1-layer][-1-layer-entry], matrix[-1-layer-entry][layer] = matrix[-1-layer-entry][layer],matrix[layer][layer+entry],matrix[layer+entry][-1-layer],matrix[-1-layer][-1-layer-entry]
test = Solution()
print(test.rotate([
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
]))