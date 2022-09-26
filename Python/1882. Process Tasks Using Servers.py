import heapq

def assignTasks(servers, tasks):
    # avail sorted inc by weight and then by index
    avail = []
    # busy sorted inc by time of completion
    busy = []
    for i in range(len(servers)):
        heapq.heappush(avail, (servers[i], i))
    ret = [0]*len(tasks)
    currTime = 0
    taskidx = 0
    while taskidx < len(tasks):
        # free all busy servers that just became available
        while busy and busy[0][0]<=currTime:
            currServer = busy[0][1]
            heapq.heappop(busy)
            heapq.heappush(avail, (servers[currServer], currServer))
        # if no available servers, time skip and free all busy servers that just became available
        if not avail:
            currTime = busy[0][0]
            while busy and busy[0][0]<=currTime:
                currServer = busy[0][1]
                heapq.heappop(busy)
                heapq.heappush(avail, (servers[currServer], currServer))
        # assign as many tasks in queue as possible to avail servers
        while taskidx <= min(currTime, len(tasks)-1) and avail:
            currserveridx = avail[0][1]
            heapq.heappop(avail)
            heapq.heappush(busy, (currTime+tasks[taskidx], currserveridx))
            ret[taskidx] = currserveridx
            taskidx += 1

        currTime += 1
    return ret