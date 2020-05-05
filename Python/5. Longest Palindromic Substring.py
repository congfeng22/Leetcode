class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s=="":
            return ""
        for i in range(len(s),0,-1):
            for j in range(len(s)-i+1):
                s2 = s[j:j+i]
                if s2 == s2[::-1]:
                    return s2
test = Solution()
print(test.longestPalindrome("a"))