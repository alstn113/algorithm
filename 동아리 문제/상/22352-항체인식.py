# https://www.acmicpc.net/problem/22352

from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
before_vaccine = [list(map(int, input().split())) for _ in range(N)]
after_vaccine = [list(map(int, input().split())) for _ in range(N)]
visited = [[False]*M for _ in range(N)]

isVaccinated = False


def bfs(i, j):
    global isVaccinated
    q = deque()
    q.append((i, j))
    before_check = before_vaccine[i][j]
    after_check = after_vaccine[i][j]
    if before_check != after_check:
        if isVaccinated:
            return False
        else:
            isVaccinated = True
    while q:
        x, y = q.popleft()
        for d in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            nx = x+d[0]
            ny = y+d[1]
            if not (0 <= nx < N and 0 <= ny < M):
                continue
            if visited[nx][ny]:
                continue
            if before_vaccine[nx][ny] == before_check:
                if after_vaccine[nx][ny] != after_check:
                    return False
                else:
                    visited[nx][ny] = True
                    q.append((nx, ny))
    return True


def solution():
    for i in range(N):
        for j in range(M):
            if not visited[i][j]:
                if bfs(i, j) == False:
                    print("NO")
                    return

    print("YES")


solution()
