import sys
input = sys.stdin.readline
INF = 1e9

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
K = int(input())

visited = [[INF]*N for _ in range(N)]

visited[0][0] = 0


def dfs(x, y):
    for d in ((-1, 0), (1, 0), (0, -1), (0, 1)):
        nx = x+d[0]
        ny = y+d[1]
        isBoom = 0
        if not (0 <= nx < N and 0 <= ny < N):
            continue
        if arr[nx][ny] == 1:
            continue
        if arr[nx][ny] == 2:
            isBoom = 1
        if visited[nx][ny] < visited[x][y]+1:
            continue
        visited[nx][ny] = visited[x][y]+isBoom
        dfs(nx, ny)


dfs(0, 0)

print("YES" if visited[N-1][N-1] <= K else "NO")
