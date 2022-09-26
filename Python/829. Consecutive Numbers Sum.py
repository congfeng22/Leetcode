def consecutiveNumbersSum(n):
    ret = 0
    for i in range(1, int((2*n)**0.5)+1):
        if (n-(i*(i-1))//2) % i == 0:
            ret += 1
    return ret