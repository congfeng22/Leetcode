def maxSatisfied(customers, grumpy, minutes):
    l,r = 0,minutes-1
    satisfied = 0
    for i in range(len(customers)):
        if i < minutes:
            satisfied += customers[i]
        elif not grumpy[i]:
            satisfied += customers[i]
    ret = satisfied
    while r < len(customers)-1:
        l = l+1
        r = r+1
        if grumpy[l-1]:
            satisfied -= customers[l-1]
        if grumpy[r]:
            satisfied += customers[r]
        if ret < satisfied:
            #print(l,r, satisfied)
            ret = satisfied
    return ret