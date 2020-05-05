def reverse(x):
    """
    :type x: int
    :rtype: int
    """
    if x>=0:
        y = int(str(x)[::-1])
    else:
        y = -int(str(x)[1:][::-1])
    if x<=2**31-1 and y<=2**31-1 and x>=-2**31 and y>=-2**31:
        return y
    else:
        return 0
print(reverse(-199))