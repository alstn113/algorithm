import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))

dp = [N + 1] * N  # 최대값으로 초기화
dp[0] = 0

for i in range(N):
    for j in range(1, data[i]+1):
        if i+j < N:
            dp[i+j] = min(dp[i+j], dp[i] + 1)


print(dp[N-1] if dp[N-1] != N+1 else -1)
