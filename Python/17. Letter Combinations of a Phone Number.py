class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        letcomb = [[]]
        letdict = {'2': ['a','b','c'], '3': ['d','e','f'], '4': ['g','h','i'], '5': ['j','k','l'], '6': ['m','n','o'], '7': ['p','q','r','s'], '8': ['t','u','v'], '9': ['w','x','y','z']}
        if digits == "":
            return []
        for i in digits:
            
            dummy = []
            for j in letdict[i]:
                letcomb2 = [i+[j] for i in letcomb]
                dummy += letcomb2
            letcomb = dummy
        ans = ["".join(i) for i in letcomb]
        return ans
test = Solution()
print(test.letterCombinations("27"))