import collections
def frogPosition(n,edges,t,target):
    adj = {i:set() for i in range(1,n+1)}
    for e in edges:
        adj[e[0]].add(e[1])
        adj[e[1]].add(e[0])
    prev = [0 for _ in range(n+1)]
    numChilds = [0 for _ in range(n+1)]
    queue = collections.deque()
    queue.append(1)
    visited = set()
    while queue:
        currPar = queue.popleft()
        for child in adj[currPar]:
            if child not in visited:
                queue.append(child)
                prev[child] = currPar
                numChilds[currPar] += 1
        visited.add(currPar)
    path = [target]
    while path[-1] != 1:
        path.append(prev[path[-1]])
    res = 1
    if t < len(path)-1 or (t > len(path)-1 and numChilds[target]):
        return 0
    for i in range(len(path)-1,0,-1):
        res /= numChilds[path[i]]
    return res