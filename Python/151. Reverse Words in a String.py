def reverseWords(s):
    return " ".join(" ".join(s.split()).split()[::-1])