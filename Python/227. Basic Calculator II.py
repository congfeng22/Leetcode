def calculate(s):
    ret = []
    idx = 0
    while idx < len(s) and s[idx] == ' ':
        idx += 1
    end = idx
    while end < len(s) and ord(s[end]) >= ord('0') and ord(s[end]) <= ord('9'):
        end += 1
    ret.append(int(s[idx:end]))
    idx = end
    #print(idx)
    while idx < len(s):
        if s[idx] == ' ':
            idx += 1
            continue
        elif s[idx] == '+':
            idx += 1
            while idx < len(s) and s[idx] == ' ':
                idx += 1
            end = idx
            while end < len(s) and ord(s[end]) >= ord('0') and ord(s[end]) <= ord('9'):
                end += 1
            ret.append(int(s[idx:end]))
        elif s[idx] == '-':
            idx += 1
            while idx < len(s) and s[idx] == ' ':
                idx += 1
            end = idx
            while end < len(s) and ord(s[end]) >= ord('0') and ord(s[end]) <= ord('9'):
                end += 1
            #print(idx, end)
            ret.append(-int(s[idx:end]))
        elif s[idx] == '*':
            idx += 1
            while idx < len(s) and s[idx] == ' ':
                idx += 1
            end = idx
            while end < len(s) and ord(s[end]) >= ord('0') and ord(s[end]) <= ord('9'):
                end += 1
            ret[-1] *= int(s[idx:end])
        elif s[idx] == '/':
            idx += 1
            while idx < len(s) and s[idx] == ' ':
                idx += 1
            end = idx
            while end < len(s) and ord(s[end]) >= ord('0') and ord(s[end]) <= ord('9'):
                end += 1
            ret[-1] = math.floor(ret[-1]/int(s[idx:end])) if ret[-1]>=0 else math.ceil(ret[-1]/int(s[idx:end]))
        idx += 1
    return sum(ret)