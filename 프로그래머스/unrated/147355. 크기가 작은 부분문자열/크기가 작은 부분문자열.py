def solution(t, p):
    cnt = 0
    for i in range(len(t) - len(p) + 1):
        a = t[i:i+len(p)]
        if int(a) <= int(p):
            cnt += 1
    
    return cnt
                
            