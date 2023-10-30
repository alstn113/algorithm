from collections import deque


def find_robot(board):
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == "R":
                return i, j

def slide(x, y, board, dx, dy):
    while True:
        x += dx
        y += dy

        is_over_block = x == -1 or y == - \
            1 or x == len(board) or y == len(board[0])
        if is_over_block or board[x][y] == "D":
            return x-dx, y-dy

def solution(board):
    robot_x, robot_y = find_robot(board)
    r, c = len(board), len(board[0])
    queue = deque([(robot_x, robot_y)])
    visited = [[-1]*c for _ in range(r)]
    visited[robot_x][robot_y] = 0

    while queue:
        x, y = queue.popleft()

        if board[x][y] == "G":
            return visited[x][y]

        for (dx, dy) in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            nx, ny = slide(x, y, board, dx, dy)

            if visited[nx][ny] != -1:
                continue

            queue.append((nx, ny))
            visited[nx][ny] = visited[x][y] + 1

    return -1
