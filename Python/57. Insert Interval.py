class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        if intervals == []:
            return [newInterval]
        newinterval = []
        dowork = []
        stop = 0
        for i in range(len(intervals)):
            if intervals[i][1]<newInterval[0]:
                newinterval.append(intervals[i])
            elif newInterval[1]>=intervals[i][0]:
                dowork.append(intervals[i])
            else:
                break
            stop += 1
        if dowork != []:
            newinterval.append([min(dowork[0][0],newInterval[0]),max(dowork[-1][-1],newInterval[1])])
        else:
            newinterval.append(newInterval)

        for j in range(stop,len(intervals)):
            newinterval.append(intervals[j])
        return newinterval

test = Solution()
print(test.insert([[1,2]],[6,8]))