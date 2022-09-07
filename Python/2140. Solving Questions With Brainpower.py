def mostPoints(questions):
    cache = {}
    def helper(questions, idx):
        if idx >= len(questions):
            return 0
        if idx in cache:
            return cache[idx]
        tryidx = helper(questions, idx+questions[idx][1]+1) + questions[idx][0]
        notryidx = helper(questions, idx+1)
        cache[idx] = max(tryidx, notryidx)
        return max(tryidx, notryidx)
    return helper(questions,0)