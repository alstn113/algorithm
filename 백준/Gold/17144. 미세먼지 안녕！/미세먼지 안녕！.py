import sys
input = sys.stdin.readline

R, C, T = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(R)]

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]


def spread():
    tmp = [[0]*C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if arr[i][j] >= 5:
                v = arr[i][j]//5
                for d in range(4):
                    nx = i+dx[d]
                    ny = j+dy[d]
                    if nx < 0 or nx >= R or ny < 0 or ny >= C:
                        continue
                    if arr[nx][ny] == -1:
                        continue
                    tmp[nx][ny] += v
                    arr[i][j] -= v

    for i in range(R):
        for j in range(C):
            arr[i][j] += tmp[i][j]


airCleaner = []
for i in range(R):
    if arr[i][0] == -1:
        airCleaner.append((i))
        airCleaner.append((i+1))
        break

for _ in range(T):
    spread()
    x1 = airCleaner[0]
    x2 = airCleaner[1]
    # 1. 위로
    for i in range(x1 - 1, 0, -1):
        arr[i][0] = arr[i - 1][0]
    # 2. 오른쪽으로
    for j in range(0, C - 1):
        arr[0][j] = arr[0][j + 1]
    # 3. 아래로
    for i in range(0, x1):
        arr[i][C - 1] = arr[i + 1][C - 1]
    # 4. 왼쪽으로
    for j in range(C - 1, 1, -1):
        arr[x1][j] = arr[x1][j - 1]

    for i in range(x2 + 1, R - 1):
        arr[i][0] = arr[i + 1][0]
    for j in range(0, C - 1):
        arr[R - 1][j] = arr[R - 1][j + 1]
    for i in range(R - 1, x2, -1):
        arr[i][C - 1] = arr[i - 1][C - 1]
    for j in range(C - 1, 1, -1):
        arr[x2][j] = arr[x2][j - 1]
    arr[x1][1], arr[x2][1] = 0, 0

result = 0
for i in range(R):
    for j in range(C):
        result += arr[i][j]

print(result+2)
