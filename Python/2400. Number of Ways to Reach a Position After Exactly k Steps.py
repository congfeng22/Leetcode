import math

def numberOfWays(startPos, endPos, k):
    if (k+abs(startPos-endPos))%2 != 0:
        return 0
    numplus = (k + endPos-startPos)//2
    return math.comb(k,numplus)%(10**9+7)
