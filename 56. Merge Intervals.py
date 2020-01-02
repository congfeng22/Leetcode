class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        newlist = []
        newlist += [(i[0],"(") for i in intervals]
        newlist += [(i[1],")") for i in intervals]
        newlist.sort()
        
        intervals = []
        opencount, closecount = 0,0
        l=0
        for i in range(len(newlist)):
            if newlist[i][1]=="(":
                opencount+=1
            else:
                closecount+=1
            if opencount==closecount:
                intervals.append([newlist[l][0],newlist[i][0]])
                l=i+1
        return intervals
test = Solution()
print(test.merge([[1,3],[3,4]]))