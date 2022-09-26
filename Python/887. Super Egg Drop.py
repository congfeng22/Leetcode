import math

def superEggDrop(k,n):
    l,r = 0,n
    while l<r:
        mid = l + (r-l)//2
        temp = 0
        for i in range(k+1):
            temp += math.comb(mid,i)
        #print(mid, temp)
        if temp > n:
            r = mid
        else:
            l = mid + 1
    return l