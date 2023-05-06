def solution(food):
    data = ""
    for i in range(len(food)):
        data += str(i)*(food[i]//2)
    
    tmp = data
    
    return data+"0"+tmp[::-1]
        
        