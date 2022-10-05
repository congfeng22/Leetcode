def calculate(s):
    idx = 0
    opstack = []
    numstack = []
    digits = [str(i) for i in range(10)]
    while idx < len(s):
        if s[idx] == ' ':
            idx += 1
        elif s[idx] in digits:
            num = 0
            while idx < len(s) and s[idx] in digits:
                num = 10*num + int(s[idx])
                idx += 1
            if opstack and opstack[-1] in ['*','/']:
                op = opstack.pop()
                first = numstack.pop()
                if op == '*':
                    numstack.append(first*num)
                else:
                    numstack.append(first//num)
            else:
                numstack.append(num)
        else:
            opstack.append(s[idx])
            idx += 1
    
    ret = numstack[0]
    for i in range(1,len(numstack)):
        op = opstack[i-1]
        if op == '+':
            ret += numstack[i]
        else:
            ret -= numstack[i]
    return ret