# https://www.acmicpc.net/problem/1520

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[-1]*M for _ in range(N)]


def dfs(x, y):
    if (x, y) == (N-1, M-1):
        return 1
    if visited[x][y] != -1:
        return visited[x][y]
    visited[x][y] = 0
    for d in ((1, 0), (0, 1), (-1, 0), (0, -1)):
        nx = x+d[0]
        ny = y+d[1]
        if not (0 <= nx < N and 0 <= ny < M):
            continue
        if arr[nx][ny] < arr[x][y]:
            visited[x][y] += dfs(nx, ny)

    return visited[x][y]


print(dfs(0, 0))
