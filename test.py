import sys
input = sys.stdin.readline
INF = 1e9

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
min_bridge = INF

for i in range(N):
    for j in range(N):
        if arr[i][j]