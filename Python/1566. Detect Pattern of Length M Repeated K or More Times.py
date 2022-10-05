def containsPattern(arr, m, k):
    idxtostr = {}
    # idxtostr[idx] = (substr at this idx, kth one)
    for idx in range(len(arr)-m+1):
        s = str(arr[idx:idx+m])
        if idx-m in idxtostr and idxtostr[idx-m][0] == s:
            if idxtostr[idx-m][1] == k-1:
                return True
            idxtostr[idx] = (s, idxtostr[idx-m][1]+1)
        else:
            idxtostr[idx] = (s, 1)
    #print(idxtostr)
    return False