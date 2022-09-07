def maximumInvitations(favorite):    
    ret = 0
    ppllen = {}
    looppairs = {}
    reachlooppairs = {}
    ppllenkeys = set()
    # find loops, and discard loops of length 3 or more
    for i in range(len(favorite)):
        # print('round {} has keys'.format(i), temp)
        # print('round {} has looppairs'.format(i), looppairs)
        # print('round {} has reachlooppairs'.format(i), reachlooppairs)

        if i not in ppllenkeys:
            visitedarr = [i]
            visited = set(visitedarr)
            fav = favorite[i]
            while fav not in visited and fav not in ppllenkeys:
                visited.add(fav)
                visitedarr.append(fav)
                fav = favorite[fav]
            # print('fav for round {} is {}'.format(i, fav))
            if fav in ppllenkeys:
                # ret = max(ret, len(visitedarr) + ppllen[fav])
                if type(reachlooppairs[fav]) == int:
                    looppairs[reachlooppairs[fav]] = max(looppairs[reachlooppairs[fav]], len(visitedarr) + ppllen[fav]-1)
                    for idx in range(len(visitedarr)):
                        ppllen[visitedarr[idx]] = len(visitedarr)-idx + ppllen[fav]
                        ppllenkeys.add(visitedarr[idx])
                        reachlooppairs[visitedarr[idx]] = reachlooppairs[fav]
            else:
                looplen = len(visitedarr)-visitedarr.index(fav)
                if looplen == 2:
                    # ret = max(ret, len(visitedarr))
                    if fav in looppairs:
                        looppairs[fav] = max(looppairs[fav], len(visitedarr)-1)
                    else:
                        looppairs[fav] = len(visitedarr)-1
                    looppairs[favorite[fav]] = looppairs.get(favorite[fav],1)
                    for idx in range(len(visitedarr)-1):
                        ppllen[visitedarr[idx]] = max(2,len(visitedarr)-idx)
                        ppllenkeys.add(visitedarr[idx])
                        reachlooppairs[visitedarr[idx]] = fav
                    ppllen[visitedarr[-1]] = 2
                    ppllenkeys.add(visitedarr[-1])
                    reachlooppairs[visitedarr[len(visitedarr)-1]] = favorite[fav]
                else:
                    ret = max(ret, looplen)
                    for person in visitedarr:
                        ppllen[person] = False
                        ppllenkeys.add(person)
                        reachlooppairs[person] = False
    return max(ret, sum(looppairs.values()))
    # return looppairs
print(maximumInvitations([1,2,3,4,5,6,7,8,9,0]))