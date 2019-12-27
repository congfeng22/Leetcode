class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n==1:
            return "1"
        val = Solution.countAndSay(self,n-1)+"0"
        count = 1
        say = ""
        if len(val)==1:
            say += str(count)
            say += str(val[0])
            return say
        for i in range(1,len(val)):
            if len(val)==1:
                say += str(count)
                say += str(val[i])
            if val[i] == val[i-1]:
                count+=1
            else:
                say += str(count)
                say += str(val[i-1])
                count = 1
        return say 
test = Solution()
print(test.countAndSay(5))