def solution(n):
    answer = [[0]*n for i in range(n)]
    value = 1
    row = 0
    col = 0
    direction = 0
    
    while value <= n*n:
        answer[row][col] = value
        value += 1
        
        if direction == 0:
            if col == n-1 or answer[row][col+1] != 0:
                direction = 1
                row += 1
            else:
                col += 1
        elif direction == 1:
            if row == n-1 or answer[row+1][col] != 0:
                direction = 2
                col -= 1
            else:
                row += 1
        elif direction == 2:
            if col == 0 or answer[row][col-1] != 0:
                direction = 3
                row -= 1
            else:
                col -= 1
                
        else:
            if row == 0 or answer[row-1][col] != 0:
                direction = 0
                col += 1
            else:
                row -= 1

    return answer