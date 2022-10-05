def gridIllumination(n, lamps, queries):
    onLine = {}
    # onLine[(i,j)] = # number of lamps in row (i=0), col (i=1), diag (i=2), antidiag(i=3), j is index
    # for diag, j is r-c
    # for antidiag, j is r+c
    lampSet = set()
    for r,c in lamps:
        if (r,c) in lampSet:
            continue
        onLine[(0,r)] = onLine.get((0,r),0)+1
        onLine[(1,c)] = onLine.get((1,c),0)+1
        onLine[(2,r-c)] = onLine.get((2,r-c),0)+1
        onLine[(3,r+c)] = onLine.get((3,r+c),0)+1
        lampSet.add((r,c))
    print(onLine)
    ans = []
    for r,c in queries:
        if (0,r) in onLine or (1,c) in onLine or (2,r-c) in onLine or (3,r+c) in onLine:
            ans.append(1)
        else:
            ans.append(0)
        for dr in [-1,0,1]:
            for dc in [-1,0,1]:
                if r+dr<0 or c+dc<0 or r+dr>=n or c+dc>=n:
                    continue
                if (r+dr, c+dc) in lampSet:
                    lampSet.remove((r+dr, c+dc))
                    onLine[(0,r+dr)] -= 1
                    onLine[(1,c+dc)] -= 1
                    onLine[(2,r+dr-c-dc)] -= 1
                    onLine[(3,r+dr+c+dc)] -= 1
                    if onLine[(0,r+dr)] == 0:
                        del onLine[(0,r+dr)]
                    if onLine[(1,c+dc)] == 0:
                        del onLine[(1,c+dc)]
                    if onLine[(2,r+dr-c-dc)] == 0:
                        del onLine[(2,r+dr-c-dc)]
                    if onLine[(3,r+dr+c+dc)] == 0:
                        del onLine[(3,r+dr+c+dc)]
    return ans
                        
            