# 배낭(dp, 냅색) 알고리즘
# https://www.acmicpc.net/problem/12865
# 물건은 하나씩 밖에 없다는 것 주의!!! 자꾸 헷갈림

import sys
input = sys.stdin.readline

N, K = map(int, input().split())

weight = [0]
value = [0]

dp = [[0]*(K+1) for _ in range(N+1)]

for i in range(N):
    w, v = map(int, input().split())
    weight.append(w)
    value.append(v)

for i in range(1, N+1):
    for j in range(1, K+1):
        if j < weight[i]:
            dp[i][j] = dp[i-1][j]
        else:
            # dp[i][j] = max(현재 물건 가치 + dp[이전 물건][현재 가방 무게 - 현재 물건 무게], dp[이전 물건][현재 가방 무게])
            dp[i][j] = max(value[i] + dp[i-1]
                           [j - weight[i]], dp[i-1][j])
print(dp[N][K])
