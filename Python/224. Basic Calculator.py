def calculate(s):
    opstack = []
    numstack = []
    idx = 0
    digits = [str(i) for i in range(10)]
    prevthing = "("
    while idx < len(s):
        if s[idx] == " ":
            idx += 1
        elif s[idx] in digits:
            num = int(s[idx])
            idx += 1
            while idx < len(s) and s[idx] in digits:
                num = num*10 + int(s[idx])
                idx += 1
            if opstack and opstack[-1] in ['+', '-']:
                first = numstack.pop()
                op = opstack.pop()
                if op == '+':
                    numstack.append(first + num)
                else:
                    numstack.append(first - num)
            else:
                numstack.append(num)
            prevthing = 1
        elif s[idx] in ['+','-','(']:
            if s[idx] == '-' and prevthing == '(':
                numstack.append(0)
            opstack.append(s[idx])
            prevthing = s[idx]
            idx += 1  
            
        else: # close bracket
            opstack.pop()
            second = numstack.pop()
            while opstack and opstack[-1] != '(':
                op = opstack.pop()
                first = numstack.pop()
                if op == '+':
                    second = first + second
                else:
                    second = first - second
            numstack.append(second)
            idx += 1
            prevthing = ')'
    return numstack.pop()