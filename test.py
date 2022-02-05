import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

dp = [[INF]*n for _ in range(n)]
dp[0][0] = 0
for i in range(n):
    for j in range(n):
        for d in ((1, 0), (0, 1)):
            nx = i+d[0]
            ny = j+d[1]
            if n <= nx or nx < 0 or n <= ny or ny < 0:
                continue
            v = 0
            if arr[i][j] <= arr[nx][ny]:
                v = arr[nx][ny]-arr[i][j]+1

            dp[nx][ny] = min(dp[nx][ny], v+dp[i][j])

print(dp[n-1][n-1])
