def evalRPN(tokens):
    stack = []
    for t in tokens:
        if t not in ['+','-','*','/']:
            stack.append(int(t))
        else:
            first = stack[-2]
            second = stack[-1]
            stack.pop()
            stack.pop()
            if t == '+':
                stack.append(first+second)
            elif t == '-':
                stack.append(first-second)
            elif t == '*':
                stack.append(first*second)
            else:
                stack.append(int(first/second))
        #print(stack)
    return stack[0]