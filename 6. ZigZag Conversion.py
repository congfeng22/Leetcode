class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s
        s2 = [[] for i in range(numRows)]
        row = 0
        for index,j in enumerate(s):
            s2[row].append(j)
            if (index%(2*numRows-2))<numRows-1:
                row +=1
            else:
                row-=1
        s2 = "".join([j for i in s2 for j in i])
        return s2
test = Solution()
print(test.convert("paypalishiring",2))