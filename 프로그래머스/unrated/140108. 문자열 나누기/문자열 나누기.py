def solution(s):
    tmp = s[0]
    a = 1
    b = 0
    answer = 0
    for i in range(1, len(s)):
        if a == b:
            tmp = s[i]
            a = 1
            b = 0
            answer += 1
            continue
        if tmp == s[i]:
            a += 1
        else:
            b += 1
    
    answer += 1
        
    return answer
        
            
        