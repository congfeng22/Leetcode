class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        
        original = ""
        while s != original:
            original = s
            s = s.replace("()","")
            s = s.replace("[]","")
            s = s.replace("{}","")
        if s == "":
            return True
        else:
            return False
test = Solution()
print(test.isValid("()()()[]{(}"))