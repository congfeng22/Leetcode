def getModifiedArray(length, updates):
    gaps = [0]*(length+1)
    # s, e, v: +v to s, s+1, ..., e
    # put +v on gap[s] and -v on gap[e+1]
    for s,e,v in updates:
        gaps[s] += v
        gaps[e+1] -= v
    for i in range(1,len(gaps)-1):
        gaps[i] = gaps[i-1] + gaps[i]
    gaps.pop()
    return gaps