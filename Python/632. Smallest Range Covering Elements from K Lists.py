import heapq

def smallestRange(nums):
    k = len(nums)
    if k == 1:
        return [nums[0][0], nums[0][0]]
    heap = [(nums[i][0],i,0) for i in range(k)]
    # number, index of list, ptr in list
    upper = max(heap)[0]
    heapq.heapify(heap)
    bestrange = [heap[0][0], upper]
    while True:
        lower, lowerList, lowerIdx = heapq.heappop(heap)
        if lowerIdx == len(nums[lowerList])-1:
            break
        upper = max(upper, nums[lowerList][lowerIdx+1])
        heapq.heappush(heap, (nums[lowerList][lowerIdx+1], lowerList, lowerIdx+1))
        if bestrange[1]-bestrange[0] > upper-heap[0][0]:
            bestrange = [heap[0][0], upper]
    return bestrange