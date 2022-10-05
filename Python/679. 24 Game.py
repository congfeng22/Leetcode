def judgePoint24(cards):
    # Try to get to target using cards
    if len(cards) == 1 and abs(cards[0]-24)<10e-3:
        return True
    # pick 2 elements in cards to combine and put in cards
    for i in range(len(cards)-1):
        for j in range(i+1, len(cards)):
            copy = cards.copy()
            n1, n2 = copy[i], copy[j]
            copy.remove(n1)
            copy.remove(n2)
            ret = False
            copy.append(n1+n2)
            ret |= judgePoint24(copy)
            if ret == True:
                return True
            copy.pop()
            copy.append(n1-n2)
            ret |= judgePoint24(copy)
            if ret == True:
                return True
            copy.pop()
            copy.append(n2-n1)
            ret |= judgePoint24(copy)
            if ret == True:
                return True
            copy.pop()
            copy.append(n1*n2)
            ret |= judgePoint24(copy)
            if ret == True:
                return True
            copy.pop()
            if n2 != 0:
                copy.append(n1/n2)
                ret |= judgePoint24(copy)
                if ret == True:
                    return True
                copy.pop()
            if n1 != 0:
                copy.append(n2/n1)
                ret |= judgePoint24(copy)
                if ret == True:
                    return True
    return False