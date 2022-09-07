def minWindow(s,t):
    tdict = {}
    for c in t:
        tdict[c] = tdict.get(c,0) + 1
    sdict = {}
    l,r = 0,0
    currmin = float('infinity')
    bestl, bestr = 0,-1
    if s[0] in tdict:
        sdict[s[0]] = 1
    countEnough = 1 if tdict.get(s[0],0) == 1 else 0
    totalcount = len(tdict.keys())
    while r<len(s):
        if countEnough < totalcount:
            r += 1
            if r >= len(s):
                return s[bestl:bestr+1]
            if s[r] in tdict:
                sdict[s[r]] = sdict.get(s[r],0) + 1
                if sdict[s[r]] == tdict[s[r]]:
                    countEnough += 1
        else:
            if currmin > r-l+1:
                currmin = r-l+1
                bestl, bestr = l,r
            l += 1
            if s[l-1] in tdict:
                sdict[s[l-1]] = sdict[s[l-1]] - 1
                if sdict[s[l-1]] == tdict[s[l-1]] - 1:
                    countEnough -= 1
    return s[bestl:bestr+1]