import sys
input = sys.stdin.readline


def solution(dp, n):

    dp[1] = 1
    dp[2] = dp[1] * 1 + 4  # 1개 * 1개 + 4개 = 5
    # 이제부터 분리 안되는 덩어리는 짝수일 때 3개, 홀수일 때 2개
    # dp[3] = dp[1] * 4 + dp[2] * 1 + 2  # 1개 * 4개 + 5개 * 1개 + 2개 = 11
    # dp[4] = dp[1] * 2 + dp[2] * 4 + dp[3] * 1 + 3  # 2 +
    # dp[5] = dp[1] * 3 + dp[2] * 2 + dp[3] * 4 + dp[4] * 1 + 2
    # dp[6] = dp[1] * 2 + dp[2] * 3 + dp[3] * 2 + dp[4] * 4 + dp[5] * 1 + 3

    for i in range(3, n+1):
        if len(dp) - 1 < i:
            dp.append(0)

        for j in range(1, i-3+1):
            if (i-j) % 2 == 0:
                dp[i] += dp[j]*3
            else:
                dp[i] += dp[j]*2

        dp[i] += dp[i-2]*4
        dp[i] += dp[i-1]*1
        dp[i] += 3 if i % 2 == 0 else 2


T = int(input())
case = []
for _ in range(T):
    n = int(input())
    case.append(n)
maxCase = max(case)

dp = [0, 1, 5]

solution(dp, maxCase)
for c in case:
    print(dp[c])
