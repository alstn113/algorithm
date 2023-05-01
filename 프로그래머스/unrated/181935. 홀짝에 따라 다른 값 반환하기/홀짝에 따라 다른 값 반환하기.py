def solution(n):
    cnt = 0
    if n%2 == 0:
        for i in range(2, n+1, 2):
            cnt += i**2
    else:
        for i in range(1, n+1, 2):
            cnt += i
        
    return cnt