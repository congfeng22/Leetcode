def maxProfit(prices):
    minSoFar = float('infinity')
    ret = 0
    for i in range(len(prices)):
        minSoFar = min(minSoFar, prices[i])
        ret = max(ret,prices[i]-minSoFar)
    return ret