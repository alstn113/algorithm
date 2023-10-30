from collections import deque


def find_robot_and_target(board):
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == "R":
                return i, j


def solution(board):
    robot_x, robot_y = find_robot_and_target(board)
    r, c = len(board), len(board[0])
    queue = deque([(robot_x, robot_y, 0)])
    visited = [[False]*c for _ in range(r)]
    visited[robot_x][robot_y] = True

    while queue:
        x, y, cnt = queue.popleft()

        if board[x][y] == "G":
            return cnt

        for (dx, dy) in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            nx = x
            ny = y

            while True:
                nx += dx
                ny += dy

                is_over_block = nx == -1 or ny == -1 or nx == r or ny == c
                if is_over_block or board[nx][ny] == "D":
                    nx -= dx
                    ny -= dy

                    if visited[nx][ny]:
                        break

                    queue.append((nx, ny, cnt+1))
                    visited[nx][ny] = True
    return -1
