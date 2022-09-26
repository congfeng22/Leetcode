def numPairsDivisibleBy60(time):
    modulos = [0]*60
    for t in time:
        modulos[t%60] += 1
    ret = 0
    ret += modulos[0] * (modulos[0]-1)//2
    ret += modulos[30] * (modulos[30]-1)//2
    for i in range(1,30):
        ret += modulos[i]*modulos[60-i]
    #print([(i, modulos[i]) for i in range(60)])
    return ret