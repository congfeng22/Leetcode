class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        return [int(i) for i in str(int("".join([str(i) for i in digits]))+1)]
test = Solution()
print(test.plusOne([1,2,3]))