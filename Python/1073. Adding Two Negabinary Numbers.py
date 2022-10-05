def addNegabinary(arr1, arr2):
    ptr = 0
    ret = [0]*(max(len(arr1),len(arr2))+3)
    while ptr < len(arr1) or ptr < len(arr2):
        if ptr < len(arr1):
            num1 = arr1[len(arr1)-1-ptr]
        else:
            num1 = 0
        if ptr < len(arr2):
            num2 = arr2[len(arr2)-1-ptr]
        else:
            num2 = 0
        ret[ptr] += num1+num2
        if ret[ptr] == 4:
            ret[ptr] = 0
            ret[ptr+2] += 1
        elif ret[ptr] in [2,3]:
            ret[ptr] = ret[ptr]%2
            ret[ptr+1] += 1
            ret[ptr+2] += 1
        elif ret[ptr] == -1:
            ret[ptr] = 1
            ret[ptr+1] = 1
        ptr += 1
    while ptr < len(ret)-1:
        if ret[ptr] >= 2:
            ret[ptr] -= 2
            ret[ptr+1] -= 1
        ptr += 1
    while len(ret)>1 and ret[-1] == 0:
        ret.pop()
    return ret[::-1]