def frequencySort(s):
    freq = {}
    for c in s:
        freq[c] = freq.get(c,0)+1
    ret = list(freq.items())
    ret.sort(key=lambda x: x[1], reverse=True)
    return str.join('',[c[0]*c[1] for c in ret])