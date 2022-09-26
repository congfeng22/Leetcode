from collections import Counter

def reorganizeString(s):
    slist = [item for items, c in Counter(list(s)).most_common() for item in [items] * c]
    newlist = []
    ptr1, ptr2 = 0, (len(slist)+1)//2
    #print(slist)
    while ptr1<(len(slist)+1)//2 and ptr2<len(slist):
        newlist.append(slist[ptr1])
        newlist.append(slist[ptr2])
        ptr1 += 1
        ptr2 += 1
    if ptr1 < (len(slist)+1)//2:
        newlist.append(slist[ptr1])
    #print(newlist)
    ret = "".join(newlist)
    for i in range(1,len(ret)):
        if ret[i] == ret[i-1]:
            return ""
    return ret