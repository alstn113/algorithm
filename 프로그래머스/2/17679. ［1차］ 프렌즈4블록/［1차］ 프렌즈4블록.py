def solution(m, n, board):
    cnt = 0
    # data 정의
    data = [[0]*n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            data[i][j] = [board[i][j], False]
    while True:
        # 2x2 블록 제거
        temp_cnt = 0
        for i in range(m-1):
            for j in range(n-1):
                if data[i][j][0] == data[i+1][j][0] == data[i][j+1][0] == data[i+1][j+1][0] != 'X':
                    data[i][j][1] = True
                    data[i+1][j][1] = True
                    data[i][j+1][1] = True
                    data[i+1][j+1][1] = True
        for i in range(m):
            for j in range(n):
                if data[i][j][0] != 'X' and data[i][j][1] == True:
                    data[i][j] = ['X', False]
                    temp_cnt += 1
        cnt += temp_cnt

        if temp_cnt == 0:
            break
        # 없어진 블록 채우기
        for _ in range(m-1):  # 최대 m-1번
            for j in range(n):
                for i in range(m-2, -1, -1):
                    if data[i+1][j] == ['X', False]:
                        data[i+1][j], data[i][j] = data[i][j], data[i+1][j]

    return cnt
