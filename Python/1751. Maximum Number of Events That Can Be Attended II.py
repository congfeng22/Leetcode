def maxValue(events, k):
    # dp[i][j] = events[i:], can only attend max k-j events (j events attended out of maximum k)
    # want dp[0][0]
    dp = [[0 for _ in range(k+1)] for _ in range(len(events)+1)]
    
    # sort events by start time
    events.sort()
    def bs(events, endTime):
        # return smallest idx such that events[idx][0] > endTime, or len(events) if doesn't exist
        l,r = 0, len(events)
        while l<r:
            m = l + (r-l)//2
            if events[m][0]>endTime:
                r = m
            else:
                l = m+1
        return l
    
    # base cases are already initialized as 0.
    for i in range(len(events)-1,-1,-1):
        for j in range(k-1,-1,-1):
            # if don't attend event[i]
            res = dp[i+1][j]
            
            # if attend event[i]
            newidx = bs(events,events[i][1])
            res = max(res, dp[newidx][j+1] + events[i][2])
            dp[i][j] = res
    # for i in range(len(dp)):
    #     print(dp[i]) 
    return dp[0][0]