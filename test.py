import sys
input = sys.stdin.readline

dp = [0]*10001

dp[1] = 1
dp[2] = 2
dp[3] = 4

N = int(input())
tmp = []
for i in range(N):
    tmp.append(int(input()))

MAX = max(tmp)
print(tmp)
print(MAX)
for i in range(4,MAX):
    dp[i] = dp[i-1]+dp[i-2]+dp[i-3]

print(dp[:10])
for i in tmp:
    print(dp[i])
