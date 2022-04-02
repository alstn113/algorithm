from collections import deque
from re import T
import sys
input = sys.stdin.readline


timetable = [[['.' for _ in range(8)] for _ in range(8)] for _ in range(8)]
visited = [[[False for _ in range(8)] for _ in range(8)] for _ in range(8)]
timetable[0] = [list(input().rstrip()) for _ in range(8)]

for k in range(1, 8):
    for i in range(1, 8):
        for j in range(8):
            if timetable[k-1][i-1][j] == "#":
                timetable[k][i][j] = "#"


def bfs():
    q = deque()
    q.append((0, 7, 0))
    while q:
        time, x, y = q.popleft()
        if (x, y) == (0, 7):
            return 1
        if visited[time][x][y]:
            continue
        visited[time][x][y] = True
        for d in ((0, 0), (-1, 0), (1, 0), (0, -1), (0, 1), (1, 1), (-1, -1), (1, -1), (-1, 1)):
            if time < 8:
                nx = x+d[0]
                ny = y+d[1]
                if not (0 <= nx < 8 and 0 <= ny < 8):
                    continue
                if timetable[time+1][nx][ny] == "#":
                    continue
                if timetable[time][nx][ny] == "#":
                    continue
                q.append((time+1, nx, ny))
            else:
                return 1
    return 0


print(bfs())
