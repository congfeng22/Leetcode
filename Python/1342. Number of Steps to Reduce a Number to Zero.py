def numberOfSteps(num):
    if num == 0:
        return 0
    return numberOfSteps(num//2)+1 if num%2==0 else numberOfSteps(num-1)+1