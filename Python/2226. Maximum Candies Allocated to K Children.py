def maximumCandies(candies)
    def check(a):
        cnt = 0
        for pile in candies:
            cnt += pile//a
            if cnt >= k:
                return True
        return False
    l,r = 1,sum(candies)//k+1
    while l<r:
        mid = l + (r-l)//2
        works = check(mid)
        if works:
            l = mid+1
        else:
            r = mid
    return l-1