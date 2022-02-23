n, m = map(int, input().split())
base = [list(map(str, input())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
dist = [[0] * m for _ in range(n)]
flag = False


def sol(x, y, px, py, color):
    if visited[x][y]:
        return True
    visited[x][y] = True
    for k in range(0, 4):
        nx = x+dx[k]
        ny = y+dy[k]
        if (0 <= nx and nx < n) and (0 <= ny and ny < m):
            if (not(nx == px and ny == py) and base[nx][ny] == color):
                if sol(nx, ny, x, y, color):
                    return True

    return False


for i in range(n):
    for j in range(m):
        if visited[i][j]:
            continue
        if sol(i, j, 0, 0, base[i][j]):
            flag = True
            break
print("Yes") if flag else print("No")
