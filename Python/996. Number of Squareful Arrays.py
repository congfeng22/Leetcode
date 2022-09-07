import math
def numSquarefulPerms(nums):
    adj = {}
    for i in range(len(nums)-1):
        for j in range(i+1,len(nums)):
            if round(math.sqrt(nums[i] + nums[j]))**2 == nums[i] + nums[j]:
                if nums[i] in adj:
                    adj[nums[i]].add(nums[j])
                else:
                    adj[nums[i]] = {nums[j]}
                if nums[j] in adj:
                    adj[nums[j]].add(nums[i])
                else:
                    adj[nums[j]] = {nums[i]}
    freq = {}
    for n in nums:
        freq[n] = freq.get(n,0)+1
        freq['total'] = freq.get('total',0)+1
    #print(adj)
    #print(freq)
    # count number of paths that hits every vertex v exactly freq[v] times.
    vlist = list(set(nums))
    def dfs(freq, v):
        print(freq, v)
        ret = 0
        #at v, with freq
        if freq[v] < 0:
            return 0
        if freq['total'] == 0:
            return 1
        for nei in adj.get(v,{}):
            freq[nei]-=1
            freq['total']-=1
            ret += dfs(freq, nei)
            freq[nei]+=1
            freq['total']+=1
        return ret
        
    ret = 0
    for s in vlist:
        #print(vlist)
        freq[s]-=1
        freq['total']-=1
        ret += dfs(freq, s)
        freq[s]+=1
        freq['total']+=1
        
    return ret