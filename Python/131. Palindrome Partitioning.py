def partition(s):
    ret = []
    def isPalindrome(s,j, i):
        # checks if s[j:i] is a palindrome
        l,r = j,i-1
        while l<r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True
    
    def dfs(s, j, path):
        # do partition on s[j:]
        if j == len(s):
            ret.append(path)
            return
        for i in range(j+1, len(s)+1):
            if isPalindrome(s,j,i):
                dfs(s,i, path+[s[j:i]])
    dfs(s,0,[])
    return ret