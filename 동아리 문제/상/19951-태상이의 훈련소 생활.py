# https://www.acmicpc.net/problem/19951

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
H_list = list(map(int, input().split()))

check = [0]*(N+1)
for i in range(M):
    a, b, k = map(int, input().split())
    check[a-1] += k
    check[b] -= k

arr = [0]*(N+1)
for i in range(1, N+1):
    arr[i] = arr[i-1]+check[i-1]


answer = list(map(lambda x, y: x+y, H_list, arr[1:]))

print(" ".join(map(str, answer)))
