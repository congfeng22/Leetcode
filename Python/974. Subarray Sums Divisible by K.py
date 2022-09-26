def subarraysDivByK(nums, k):
    modulos = [0]*k
    curr = 0
    modulos[0] = 1
    for n in nums:
        curr += n
        modulos[curr%k] += 1
    ret = 0
    for i in range(k):
        ret += modulos[i] * (modulos[i]-1) // 2
    return ret