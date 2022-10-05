def preimageSizeFZF(k):
    l,r = 0,5*(k+1)
    # smallest n such that n! has k+1 zeros
    while l<r:
        m = l+(r-l)//2
        ans = 0
        power = 1
        while m//(5**power):
            ans += m//(5**power)
            power += 1
        if ans > k:
            r=m
        else:
            l=m+1
    upper = l
    
    l,r = 0,5*(k+1)
    # smallest n such that n! has k zeros
    while l<r:
        m = l+(r-l)//2
        ans = 0
        power = 1
        while m//(5**power):
            ans += m//(5**power)
            power += 1
        if ans >= k:
            r=m
        else:
            l=m+1
    return upper-l