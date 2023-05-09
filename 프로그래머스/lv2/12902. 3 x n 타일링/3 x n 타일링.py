def solution(n):
    answer = 0
    dp = [0]*(n+1)
    dp[0] = 1
    dp[2] = 3
    
    if n%2 != 0:
        return 0
    for i in range(4, n+1, 2):
        dp[i] += 3*dp[i-2]%1000000007
        for j in range(0, i-4+1, 2):
            dp[i] += 2*dp[j]%1000000007
        
    return dp[n]%1000000007