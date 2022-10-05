def longestPath(parent, s):
    children = {}
    
    cache = {}
    
    for i in range(len(parent)):
        if parent[i] < 0:
            continue
        if parent[i] not in children:
            children[parent[i]] = set()
        children[parent[i]].add(i)
    
    def dfs(i):
        # get length of 2 max paths down node i 
        if i in cache:
            return cache[i]
        maxpath1, maxpath2 = 1,1
        for child in children.get(i, set()):
            if s[child] != s[i]:
                newpath = 1+dfs(child)[0]
                if newpath > maxpath1:
                    maxpath1, maxpath2 = newpath, maxpath1
                elif newpath > maxpath2:
                    maxpath2 = newpath
        cache[i] = (maxpath1, maxpath2)
        return cache[i]
    for i in range(len(parent)):
        dfs(i)
    # print(cache)
    # print(children)
    ret = 0
    for i in range(len(parent)):
        ret = max(sum(cache.get(i,(1,1)))-1, ret)
    return ret