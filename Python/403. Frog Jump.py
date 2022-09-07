def canCross(stones):
    cache = {}
    # cache[(idx, k)] = possible to get from idx to end, given that prev jump was k
    def bsearch(unit):
        # return index of unit in array, or closest if it doesnt exist.
        if unit>stones[-1]:
            return len(stones)-1
        l,r = 0,len(stones)
        while l<=r:
            mid = l + (r-l)//2
            if stones[mid]>unit:
                r = mid-1
            elif stones[mid]<unit:
                l = mid+1
            else:
                return mid
        return l
    
    def dfs(idx, k):
        # possible to get from idx to end, given that prev jump was k
        if idx == len(stones)-1:
            cache[idx]=True
            return True
        if idx in cache:
            return True
        if (idx,k) in cache:
            return cache[(idx,k)]
        if k==1:
            nidx = bsearch(stones[idx]+k)
            result = False
            if stones[nidx]-stones[idx] in [k, k+1]:
                result = result or dfs(nidx, stones[nidx]-stones[idx])
            if nidx+1 < len(stones) and stones[nidx+1]-stones[idx] == k+1:
                result = result or dfs(nidx+1, k+1)
        else:
            nidx = bsearch(stones[idx]+k-1)
            result = False
            if stones[nidx]-stones[idx] in [k-1, k, k+1]:
                result = result or dfs(nidx, stones[nidx]-stones[idx])
            if nidx+1 < len(stones) and stones[nidx+1]-stones[idx] in [k, k+1]:
                result = result or dfs(nidx+1, stones[nidx+1]-stones[idx])
            if nidx+2 < len(stones) and stones[nidx+2]-stones[idx] == k+1:
                result = result or dfs(nidx+2, k+1)
        cache[(idx,k)] = result            
        return result
    
    if stones[1]!=1:
        return False
    if len(stones)==2:
        return True
    dfs(1, 1)
    print(len(stones)-1 in cache)
    print(cache)
           0,1,2,3,4 ,5 ,6 ,7 ,8 ,9 ,10
canCross([0,1,3,6,7])



# stones = [0,1,3,6,10,13,15,16,19,21,25]
# def bsearch(unit):
#     # return index of unit in array, or closest if it doesnt exist.
#     if unit>stones[-1]:
#         return len(stones)-1
#     l,r = 0,len(stones)
#     while l<=r:
#         mid = l + (r-l)//2
#         if stones[mid]>unit:
#             r = mid-1
#         elif stones[mid]<unit:
#             l = mid+1
#         else:
#             return mid
#     return l
    
    
# print(bsearch(13))