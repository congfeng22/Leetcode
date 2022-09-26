def numTeams(rating):
    leftMore = [0]*len(rating)
    # leftMore[i] = # soldiers to the left of soldier i with a higher rating
    rightMore = [0]*len(rating)
    # rightMore[i] = # soldiers to the right of soldier i with a higher rating
    for i in range(len(rating)):
        for j in range(i):
            if rating[j]>rating[i]:
                leftMore[i] += 1
    for i in range(len(rating)):
        for j in range(i+1,len(rating)):
            if rating[j]>rating[i]:
                rightMore[i] += 1
    ret = 0
    for i in range(1,len(rating)-1):
        ret += leftMore[i]*(len(rating)-1-i-rightMore[i]) + (i-leftMore[i])*rightMore[i]
    return ret