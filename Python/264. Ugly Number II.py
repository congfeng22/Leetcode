def nthUglyNumber(n):
    idxes = [0,0,0]
    #idxes[0] = index of smallest ugly number satisfying 2*x > newest ugly number
    uglies = [1]
    if n == 1:
        return 1
    for i in range(n-1):
        nextugly = min(2*uglies[idxes[0]], 3*uglies[idxes[1]], 5*uglies[idxes[2]])
        if nextugly == 2*uglies[idxes[0]]:
            idxes[0] += 1
        if nextugly == 3*uglies[idxes[1]]:
            idxes[1] += 1
        if nextugly == 5*uglies[idxes[2]]:
            idxes[2] += 1
        uglies.append(nextugly)
    return uglies[-1]