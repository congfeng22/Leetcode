class Solution(object):
    def ndict(self, curdict):
        #creates the next item and add it to curdict 1:["()"], 2:["()()","(())"], etc
        n = list(curdict.keys())[-1]+1
        nlist = []
        for i in range(1,n):
            thing = ["("+j+")"+k for k in curdict[n-i] for j in curdict[i-1]]
            nlist+=thing
        lastthing = ["(" + k + ")" for k in curdict[n-1]]
        nlist+=lastthing
        curdict[n] = nlist
        return curdict
    
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        curdict = {0: [""]}
        for i in range(n):
            curdict = Solution.ndict(self,curdict)
        return curdict[n]
        #f(n) = "() + f(n-1)" + "(()) + f(n-2)" + ... + ""((...))" *f(1)" + "( + f(n-1) + )"
test = Solution()
print(test.generateParenthesis(3))