from collections import deque


def bfs(x, y):
    queue = deque([(x, y)])
    visited[x][y] = 0
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            # 동 남 서 북 순서
            nx, ny = x + dx[i], y + dy[i]
            while True:
                # 범위를 벗어난다
                if not (0 <= nx < n and 0 <= ny < m):
                    break
                # 벽을 만난다
                if board[nx][ny] == "*":
                    break
                # 지난 적 있는 곳인데, 지금 경로로는 너무 많은 거울이 필요해서 break
                if visited[nx][ny] < visited[x][y] + 1:
                    break
                # board업데이트, queue 추가
                queue.append((nx, ny))
                visited[nx][ny] = visited[x][y] + 1
                nx = nx + dx[i]
                ny = ny + dy[i]


if __name__ == "__main__":
    # 입력값
    m, n = map(int, input().split())
    board = [input() for _ in range(n)]

    # 동 남 서 북
    dx = (0, 1, 0, -1)
    dy = (1, 0, -1, 0)

    # C위치
    C = []
    for i in range(n):
        for j in range(m):
            if board[i][j] == "C":
                C.append((i, j))
    # sx,sy : 시작지점
    # ex,ey : 도착지점
    (sx, sy), (ex, ey) = C

    visited = [[float("inf")] * m for _ in range(n)]
    bfs(sx, sy)

    print(visited[ex][ey] - 1)


# 코드 참고 : https://www.acmicpc.net/source/27251914
