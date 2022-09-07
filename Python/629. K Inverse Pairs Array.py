import numpy as np

def kInversePairs(n,k):
    mod = 10**9+7
    if k > n*(n-1)//2:
        return 0
    if k > n*(n-1)//4:
        k = n*(n-1)//2-k
    if k == 0:
        return 1
    if n == 1:
        return 0 if k == 1 else 1
    if n == 2:
        return 1 if k < 2 else 0
    dp = np.zeros((2,k+1))
    dp[0][0]=1
    dp[0][1]=1
    num = 2
    while num < n:
        dp[1][0]=1
        for i in range(1,k+1):
            dp[1][i]=(dp[0][i]+dp[1][i-1])%mod
        for i in range(0,k+1):
            if i < num+1:
                dp[0][i]=dp[1][i]
            else:
                dp[0][i]=(dp[1][i]-dp[1][i-num-1])%mod
        num += 1
    return int(dp[0][k])

print(int(kInversePairs(100,100)))