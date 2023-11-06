
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[False]*M for _ in range(N)]

answer = 0


def dfs(x, y, cnt, total):
    global answer
    if cnt == 4:
        answer = max(answer, total)
        return
    for d in ((1, 0), (-1, 0), (0, 1), (0, -1)):
        nx = x+d[0]
        ny = y+d[1]
        if not (0 <= nx < N and 0 <= ny < M):
            continue
        if visited[nx][ny]:
            continue
        if cnt == 2:
            visited[nx][ny] = True
            dfs(x, y, cnt+1, total+arr[nx][ny])
            visited[nx][ny] = False
        visited[nx][ny] = True
        dfs(nx, ny, cnt+1, total+arr[nx][ny])
        visited[nx][ny] = False


for i in range(N):
    for j in range(M):
        visited[i][j] = True
        dfs(i, j, 1, arr[i][j])
        visited[i][j] = False


print(answer)
