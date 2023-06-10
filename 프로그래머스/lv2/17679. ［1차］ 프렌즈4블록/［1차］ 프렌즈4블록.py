def solution(m, n, board):
    answer = 0
    # data 정의
    data = []
    for i in range(m):
        tmp = []
        for j in range(n):
            tmp.append([board[i][j], False])
        data.append(tmp)
    while True:
        # 2x2 블록 제거
        temp_cnt = 0
        for i in range(m-1):
            for j in range(n-1):
                if data[i][j][0] == "X":
                    continue
                if data[i][j][0] == data[i+1][j][0] == data[i][j+1][0] == data[i+1][j+1][0]:
                    data[i][j][1] = True
                    data[i+1][j][1] = True
                    data[i][j+1][1] = True
                    data[i+1][j+1][1] = True
        for i in range(m):
            for j in range(n):   
                if data[i][j][0] == 'X':
                    continue
                if data[i][j][1] == True:
                    data[i][j] = ['X', False]
                    temp_cnt += 1
        answer += temp_cnt

        if temp_cnt == 0:
            break
            
      # 없어진 블록 채우기    
        for _ in range(m-1):
            for i in range(m-2, -1, -1):
                for j in range(n):
                    if data[i+1][j] == ['X', False]:
                        data[i+1][j], data[i][j]  = data[i][j], data[i+1][j]
                    
    return answer