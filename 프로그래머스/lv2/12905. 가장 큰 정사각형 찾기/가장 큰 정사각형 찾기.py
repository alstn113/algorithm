def solution(b):
    R = len(b)
    C = len(b[0])
    
    for i in range(1, R):
        for j in range(1, C):
            if b[i][j] == 1:
                b[i][j] = min(b[i-1][j], b[i-1][j-1], b[i][j-1]) + 1
    
    answer = 0
    for i in range(R):
        temp = max(b[i])
        answer = max(answer, temp)
    
    return answer**2                
    
            