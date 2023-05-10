import sys
input = sys.stdin.readline

INF = 1e9

N = int(input())
data = [list(map(int, input().split())) for _ in range(N)]

answer = INF
for k in range(3):
    dp = [[INF]*3 for _ in range(N)]
    dp[0][k] = data[0][k]
    for i in range(1, N):
        dp[i][0] = data[i][0] + min(dp[i-1][1], dp[i-1][2])
        dp[i][1] = data[i][1] + min(dp[i-1][0], dp[i-1][2])
        dp[i][2] = data[i][2] + min(dp[i-1][0], dp[i-1][1])

    for i in range(3):
        if k == i:
            continue
        answer = min(answer, dp[N-1][i])


print(answer)
