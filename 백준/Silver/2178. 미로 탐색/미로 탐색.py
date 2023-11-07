from collections import deque
import sys
input = sys.stdin.readline


N, M = map(int, input().split())

data = [list(input()) for _ in range(N)]
visited = [[False]*M for _ in range(N)]
q = deque()
q.append([0, 0, 1])

while q:
    x, y, cnt = q.popleft()

    if (x, y) == (N-1, M-1):
        print(cnt)
        break

    for (dx, dy) in ((0, 1), (0, -1), (1, 0), (-1, 0)):
        nx = x + dx
        ny = y + dy

        if not ((0 <= nx < N) and (0 <= ny < M)):
            continue

        if visited[nx][ny]:
            continue

        if data[nx][ny] == "0":
            continue

        visited[nx][ny] = True
        q.append([nx, ny, cnt+1])
