from collections import deque

INF = 1e9
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[INF]*N for _ in range(N)]


def bfs():
    q = deque()
    q.append((0, 0))
    visited[0][0] = 0
    while q:
        x, y = q.popleft()
        for d in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            nx = x+d[0]
            ny = y+d[1]
            while True:
                if not (0 <= nx < N and 0 <= ny < N):
                    break
                if arr[nx][ny] == 1:
                    break
                nx += d[0]
                ny += d[1]
            nx -= d[0]
            ny -= d[1]
            if visited[nx][ny] < visited[x][y]+1:
                continue

            q.append((nx, ny))
            visited[nx][ny] = visited[x][y]+1


bfs()

print("No path" if visited[N-1][N-1] == INF else visited[N-1][N-1])
