def calculate(s):
    opstack = []
    numstack = []
    ptr = 0
    digits = [str(i) for i in range(10)]
    while ptr < len(s):
        # print(opstack)
        # print(numstack)
        # print(s[ptr])
        # print()
        if s[ptr] == " ":
            ptr += 1
            continue
        if s[ptr] in digits:
            num = int(s[ptr])
            ptr += 1
            while ptr < len(s) and s[ptr] in digits:
                num = num*10+int(s[ptr])
                ptr += 1
            if numstack and opstack[-1] in ['*','/']:
                first = numstack.pop()
                if opstack[-1] == '*':
                    numstack.append(first*num)
                else:
                    numstack.append(first//num)
                opstack.pop()
            else:
                numstack.append(num)
            continue
        if s[ptr] in ['+', '-', '*', '/', '(']:
            opstack.append(s[ptr])
            ptr += 1
            continue
        if s[ptr] == ')':
            second = numstack.pop()
            while opstack[-1] != '(':
                op = opstack.pop()
                first = numstack.pop()
                if op == '+':
                    second = first + second
                else:
                    second = first-second
            opstack.pop()
            if opstack and opstack[-1] in ['*','/']:
                first = numstack.pop()
                if opstack[-1] == '*':
                    numstack.append(first*second)
                else:
                    numstack.append(first//second)
                opstack.pop()
            else:
                numstack.append(second)
            ptr += 1
    # print(opstack)
    # print(numstack) 
    
    if not numstack:
        return 0
    second = numstack.pop()
    while opstack:
        op = opstack.pop()
        first = numstack.pop()
        if op == '+':
            second = first + second
        else:
            second = first - second
    return second

print(calculate("(1+(4+5+2)-3)+(6+8)"))