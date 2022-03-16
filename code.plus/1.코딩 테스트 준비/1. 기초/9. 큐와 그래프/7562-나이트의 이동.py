from collections import deque
import sys
input = sys.stdin.readline

T = int(input())


def bfs(s_x, s_y, e_x, e_y, visited):
    q = deque([(s_x, s_y, 0)])
    visited[s_x][s_y] = True
    while q:
        x, y, cnt = q.popleft()
        if (x, y) == (e_x, e_y):
            return cnt
        for d in ((2, 1), (2, -1), (-2, 1), (-2, -1), (-1, 2), (1, 2), (-1, -2), (1, -2)):
            nx = x+d[0]
            ny = y+d[1]
            if not (0 <= nx < N and 0 <= ny < N):
                continue
            if visited[nx][ny]:
                continue
            q.append((nx, ny, cnt+1))
            visited[nx][ny] = True


for i in range(T):
    N = int(input())
    visited = [[False]*N for _ in range(N)]
    r1, c1 = map(int, input().split())
    r2, c2 = map(int, input().split())
    print(bfs(r1, c1, r2, c2, visited))
