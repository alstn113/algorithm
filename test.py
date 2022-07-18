from collections import deque

N = 6
M = 6


def bfs(x, y, visited):
    q = deque()
    q.append((x, y, 0))
    visited[x][y] = True

    while q:
        x, y, cnt = q.popleft()

        if x == 1 and y == 1:
            return cnt

        for d in ((1, 0), (0, 1), (-1, 0), (0, -1)):
            nx = x+d[0]
            ny = y+d[1]
            if not (0 <= nx < N and 0 <= ny < M):
                continue
            if visited[nx][ny]:
                continue
            visited[nx][ny] = True
            q.append((nx, ny, cnt + 1))
