def solution(lines):
    data = [0]*201
    
    for d in lines:
        s, e = d
        for i in range(s+100, e+100):
            data[i] += 1
    
    answer = 0
    for v in data:
        if v >= 2:
            answer += 1
    
    return answer
        
            