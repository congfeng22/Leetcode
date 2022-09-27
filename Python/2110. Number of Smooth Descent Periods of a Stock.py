def getDescentPeriods(prices):
    ret = 0
    consec = 1
    for i in range(1,len(prices)):
        if prices[i-1] - prices[i] != 1:
            ret += (consec * (consec + 1))//2
            consec = 1
        else:
            consec += 1
    ret += (consec * (consec + 1))//2
    return ret