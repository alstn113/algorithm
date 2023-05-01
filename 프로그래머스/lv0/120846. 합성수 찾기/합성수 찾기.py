def solution(n):
    arr = [True for _ in range(n+1)]
    arr[1] = False

    for i in range(2, int(n**0.5)+1):
        if arr[i] == True:
            j = 2
            while i*j <= n:
                arr[i*j] = False
                j += 1
    
    cnt = 0
    for a in arr:
        if not a:
            cnt += 1
    
    return cnt-1