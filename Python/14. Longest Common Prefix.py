class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        
        prefix = ""
        if strs == []:
            return prefix
        minlen = min(len(word) for word in strs)
        for index in range(minlen):
            if len(set([word[index] for word in strs])) == 1:
                prefix += strs[0][index]
                continue
            else:
                break
        return prefix
    
    
test = Solution()
print(test.longestCommonPrefix(["flower","flow","flight"]))
print(test.longestCommonPrefix(["dog","racecar","car"]))
print(test.longestCommonPrefix([]))