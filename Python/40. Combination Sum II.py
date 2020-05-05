class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        properlist = [i for i in candidates if i<=target]
        if properlist == []:
            if target == 0:
                return [[]]
            return []
        
        properdict = {}
        for i in properlist:
            properdict[i] = properdict.get(i,0)+1
        if len(set(properlist))==1 and target%properlist[0]==0 and properdict[properlist[0]]>target//properlist[0]:
            return [[properlist[0]]*(target//properlist[0])]
        newlist = properlist[:]
        allcombis = []
        times = 0
        newlist = [i for i in newlist if i!= newlist[0]]
        times = 0
        while properlist[0]*times <= target and times<=properdict[properlist[0]]:
            combis = [[properlist[0]]*times+i for i in Solution.combinationSum2(self,newlist,target-properlist[0]*times)]
            allcombis += combis
            times += 1
        return allcombis
test = Solution()
print(test.combinationSum2([1,2,2,2,2,5],5))