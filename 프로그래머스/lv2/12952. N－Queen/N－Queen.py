def possible(x, y, n, col):
    for i in range(x):
        if y == col[i] or abs(y - col[i]) == x - i:
            return False
    return True

def queen(x, n, col):
    
    if x == n:
        return 1
    
    count = 0
    
    for y in range(n):
        # 다음 퀸을 놓을 수 있는 경우만 진행
        if possible(x, y, n, col):
            col[x] = y
            count += queen(x+1, n, col) 
            
    return count

def solution(n):
    
    col = [0] * n
    answer = queen(0, n, col)
    
    return answer