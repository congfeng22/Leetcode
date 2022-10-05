def maximum69Number(num):
    temp = num
    numdigits = 0
    while temp:
        temp = temp // 10
        numdigits += 1
    for i in range(numdigits-1, -1, -1):
        if (num//(10**i)) % 10 == 9:
            continue
        else:
            return num - 6*10**i + 9*10**i
    return num
        