def findLeastNumOfUniqueInts(arr, k):
    lc = {}
    for num in arr:
        lc[num] = lc.get(num, 0)+1
    values = list(lc.values())
    values.sort()
    for i in range(len(values)):
        k = k-values[i]
        if k<0:
            return len(values)-i
    return 0