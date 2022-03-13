# https://www.acmicpc.net/problem/17427

import sys
input = sys.stdin.readline

N = int(input())

sum = 0
for i in range(1, N+1):
    sum += (N//i)*i

print(sum)

# N = 8

# 1
# 1 2
# 1 3
# 1 2 4
# 1 5
# 1 2 3 6
# 1 7
# 1 2 4 8

# i의 배수의 수 (N//i) = i를 약수로 갖는 수
