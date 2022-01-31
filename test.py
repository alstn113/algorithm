from collections import deque
import sys
input = sys.stdin.readline

arr = [[0]*501 for _ in range(501)]
visited = [[False]*501 for _ in range(501)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

N = int(input())
for _ in range(N):
    X1, Y1, X2, Y2 = map(int, input().split())
    max_X = max(X1, X2)
    min_X = min(X1, X2)
    max_Y = max(Y1, Y2)
    min_Y = min(Y1, Y2)
    for i in range(min_X, max_X+1):
        for j in range(min_Y, max_Y+1):
            arr[i][j] = -1
M = int(input())
for _ in range(M):
    X1, Y1, X2, Y2 = map(int, input().split())
    max_X = max(X1, X2)
    min_X = min(X1, X2)
    max_Y = max(Y1, Y2)
    min_Y = min(Y1, Y2)
    for i in range(min_X, max_X+1):
        for j in range(min_Y, max_Y+1):
            arr[i][j] = 1


def bfs():
    q = deque()
    q.append((0, 0, 0))
    visited[0][0] = True
    while q:
        x, y, cnt = q.popleft()
        if x == 500 and y == 500:
            print(cnt)
            return

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx < 0 or ny < 0 or nx >= 501 or ny >= 501:
                continue
            if visited[nx][ny]:
                continue
            # 죽음구역은 불가능
            if arr[nx][ny] == 1:
                continue
            # 위험구역은 가중치 1
            if arr[nx][ny] == -1:
                q.append((nx, ny, cnt+1))
                visited[nx][ny] = True
            # 안전구역은 가중치 0
            if arr[nx][ny] == 0:
                q.appendleft((nx, ny, cnt))
                visited[nx][ny] = True
    print(-1)


bfs()
