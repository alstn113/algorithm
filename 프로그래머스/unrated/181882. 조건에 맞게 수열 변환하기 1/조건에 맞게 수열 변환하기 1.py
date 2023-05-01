def solution(arr):
    answer = []
    for i in arr:
        if i%2 ==0 and i >= 50:
            answer.append(i//2)  
        elif i%2 != 0 and i<50:
            answer.append(i*2)
        else:
            answer.append(i)
    return answer
                
        
            
    