def maximumImportance(n,roads):
    degrees = [0]*n
    for a,b in roads:
        degrees[a] += 1
        degrees[b] += 1
    degrees.sort()
    return sum([degrees[i-1]*i for i in range(1,n+1)])