from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
H_list = list(map(int, input().split()))
T = [[0]*N for _ in range(M)]
for i in range(M):
    a, b, k = map(int, input().split())
    for j in range(a-1, (b-1)+1):
        T[i][j] += k

for i in range(N):
    for j in range(M):
        H_list[i] += T[j][i]
print(" ".join(map(str, H_list)))
