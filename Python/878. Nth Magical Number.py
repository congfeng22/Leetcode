import math
def nthMagincalNumber(n,a,b):    
    mod = 10**9+7
    gcd,d = max(a,b), min(a,b)
    while d != 0:
        gcd,d = d,gcd%d
    lcm = a*b//gcd
    ret = n//(lcm//a + lcm//b - 1)*lcm
    remainder = n%(lcm//a + lcm//b - 1)
    if remainder == 0:
        return ret%mod
    a,b = min(a,b),max(a,b)
    numa, numb = math.floor(remainder/(a+b)*b),math.floor(remainder/(a+b)*a)
    #print(ret)
    return (ret + min(a*(numa+1), b*(numb+1)))%mod