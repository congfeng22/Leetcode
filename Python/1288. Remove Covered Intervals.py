from collections import deque
def removeCoveredIntervals(intervals):
    queue = deque([])
    intervals.sort(key=lambda x: (x[0],-x[1]))
    queue.append(intervals[0])
    idx = 1
    ret = 0
    #print(intervals)
    while len(queue) != 0 and idx < len(intervals):
        #print(queue)
        newIntv = intervals[idx]
        #print('testing', newIntv)
        shldAdd = True
        while len(queue)!=0 and newIntv[0] >= queue[0][1]:
            #print('inwhile')
            queue.popleft()
            ret += 1
        for intv in queue:
            if newIntv[1] <= intv[1]:
                shldAdd = False
                break
        if shldAdd:
            queue.append(newIntv)
        idx += 1
    return ret + len(queue)


print(removeCoveredIntervals([[66672,75156],[59890,65654],[92950,95965],[9103,31953],[54869,69855],[33272,92693],[52631,65356],[43332,89722],[4218,57729],[20993,92876]]))