def countPrimes(n):
    if n <= 2:
        return 0
    sieve = [1 for i in range(n)]
    currp = 2
    while currp <= n**0.5:
        for i in range(2, (n-1)//currp+1):
            sieve[i*currp] = 0
        currp += 1
        while sieve[currp] == 0:
            currp += 1
    #print(list(enumerate(sieve)))
    return sum(sieve)-2