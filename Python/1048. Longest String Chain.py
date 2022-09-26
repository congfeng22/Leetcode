def longestStrChain(words):
    def isPred(a, b):
        for i in range(len(b)):
            if a == b[:i] + b[i+1:]:
                return True
        return False
    lengths = [[] for _ in range(16)]
    for w in words:
        lengths[len(w)-1].append(w)
    adj = {}
    for w in words:
        if len(w) == 16:
            continue
        adj[w] = set()
        for w2 in lengths[len(w)]:
            if isPred(w, w2):
                adj[w].add(w2)
    cache = {}
    # cache[word] = longest chain starting at word
    def getchain(w):
        if w in cache:
            return cache[w]
        longest = 1
        for nei in adj.get(w,set()):
            longest = max(longest, getchain(nei)+1)
        cache[w] = longest
        return longest
    ret = 0
    for l in range(16):
        for w in lengths[l]:
            ret = max(ret,getchain(w))
    # print(cache)
    return ret