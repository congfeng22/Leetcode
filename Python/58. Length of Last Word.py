class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        count=0
        idx=0
        while idx<len(s):
            if s[~idx]==" " and count == 0:
                idx+=1
            elif s[~idx]!=" ":
                count+=1
                idx+=1
            else:
                return count
        return max(0,count)
test = Solution()
print(test.lengthOfLastWord("a"))