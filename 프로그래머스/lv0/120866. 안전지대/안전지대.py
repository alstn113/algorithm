def solution(board):
    n = len(board)
    cnt = 0
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                continue
            flag = True
            for d in ((-1,0), (1,0), (0,-1), (0,1), (-1, -1), (-1, 1), (1, 1), (1, -1)):
                nx = i + d[0]
                ny = j + d[1]
                if not (0<= nx < n and 0<= ny < n):
                    continue
                if board[nx][ny] == 1:
                    flag = False
                    break
            if flag:
                cnt += 1
                
    return cnt
            