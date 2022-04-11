import sys
input = sys.stdin.readline
INF = 1e9
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[INF]*N for _ in range(N)]


def dfs(x, y):
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
        visited[nx][ny] = visited[x][y]+1
        dfs(nx, ny)


visited[0][0] = 0
dfs(0, 0)

print("No path" if visited[N-1][N-1] == INF else visited[N-1][N-1])
