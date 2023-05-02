# 등차수열의 합 Sn = n(2a + (n-1)d)/2

def solution(a, d, included):
    answer = 0
    for i in range(1, len(included)+1):
        if included[i-1]:
            answer += a + (i-1)*d 
        
    return answer
        
    
        

