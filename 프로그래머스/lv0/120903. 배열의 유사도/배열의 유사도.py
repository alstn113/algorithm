def solution(s1, s2):
    cnt = 0
    for i in s1:
        if i in s2:
            cnt += 1
    return cnt 
