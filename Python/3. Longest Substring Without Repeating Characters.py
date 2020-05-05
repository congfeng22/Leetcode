def lengthOfLongestSubstring(s):
    """
    :type s: str
    :rtype: int
    """
    st = ""
    maxlen = 0
    for i, char in enumerate(s):
        if char not in st:
            st += char
            maxlen = max(maxlen, len(st))
        else:
            st = s[s[:i].rindex(char)+1:i+1]
    return maxlen
if __name__ == "__main__":
    print(lengthOfLongestSubstring("bbbtabl"))