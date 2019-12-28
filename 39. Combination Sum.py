class Solution(object):
    def combinationSum(self, candidates, target):
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
        if len(properlist)==1 and target%properlist[0] ==0:
            return [properlist*(target//properlist[0])]
        newlist = properlist[:]
        allcombis = []
        times = 0
        del newlist[0]
        while properlist[0]*times<=target:
            combis = [[properlist[0]]*times+i for i in Solution.combinationSum(self,newlist,target-properlist[0]*times)]
            allcombis += combis
            times += 1
        return allcombis
test = Solution()
print(test.combinationSum([2,3,5],8))