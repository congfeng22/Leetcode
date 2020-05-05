class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        rdict = {}
        for i in strs:
            newi = "".join(sorted(i))
            rdict[newi] = rdict.get(newi,[])+[i]
        
        return [i for i in rdict.values()]
test = Solution()
print(test.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))