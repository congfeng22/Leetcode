class Solution(object):
    def myAtoi(self, string):
        """
        :type str: str
        :rtype: int
        """
        string = string.strip()
        newstr = ""
        if string == "":
            return 0
        
        if string[0] in ["+","-"]:
            newstr += string[0]
            string = string[1:]
        if string == "":
            return 0
        intstr = list(map(str,range(10)))
        for i in string:
            
            if i in intstr:
                newstr+=i
            else:
                break
        if newstr in ["+","-",""]:
            return 0
        newstr = int(newstr)
        
        return min(max(-2**31,newstr),2**31-1)
test = Solution()

print(test.myAtoi("  -52w35  "))