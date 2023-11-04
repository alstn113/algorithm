import sys
input = sys.stdin.readline

N = int(input())

data = list(map(int, input().split()))
dp = [1]*N  # 1로 초기화

for i in range(1, N):  # 1부터 N-1까지
    for j in range(i):  # 0부터 i-1까지
        if data[j] > data[i]:  # 앞에 있는 값이 더 크면
            dp[i] = max(dp[i], dp[j]+1)  # 앞에 있는 값의 길이 + 1과 비교해서 더 큰 값으로 갱신

print(N-max(dp))

# 15 11 4 8 5 2 4
#  1  2 3 3 4 5 5