def countExcellentPairs(nums,k):
    nums = set(nums)
    # count number of set bits in each number
    setBits = []
    for n in nums:
        bits = 0
        while n:
            bits += n&1
            n = n >> 1
        setBits.append(bits)
    setBits.sort()
    l,r = 0,len(setBits)-1
    result = 0
    while l <= r:
        if setBits[l] + setBits[r] >= k:
            result += 2*(r-l)+1
            r -= 1
        else:
            l += 1
    return result