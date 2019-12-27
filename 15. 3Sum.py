class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        numsdict = {}
        solnlist = []
        below0 = {}
        aboveeq0 = {}
        for i in nums:
            numsdict[i] = numsdict.get(i,0)+1
            if i<0 and numsdict.get(i,0)==1:
                below0[-i]=1
                
            elif i>=0 and numsdict.get(i,0)==1:
                aboveeq0[i]=1
        twoormores = [k for k,v in numsdict.items() if v>=2]
        
        #Case 1: all different
        ones = list(below0.keys())
        for i,a in enumerate(ones):
            for j,b in enumerate(ones[i+1:]):
                if aboveeq0.get(a+b,0):
                    solnlist.append([-a,-b,a+b])
        ones2 = list(aboveeq0.keys())
        for i,a in enumerate(ones2):
            for j,b in enumerate(ones2[i+1:]):
                if below0.get(a+b,0):
                    solnlist.append([a,b,-a-b])
        
        #Case 2: 2 same
        for i in twoormores:
            if i!=0 and numsdict.get(-2*i,0)>0:
                solnlist.append([i,i,-2*i])
        #Case 3: all same
        if numsdict.get(0,0)>=3:
            solnlist.append([0,0,0])
        
        return solnlist
        
test = Solution()
print(test.threeSum([-1, 0, 1, 2, -1, -4, -1]))