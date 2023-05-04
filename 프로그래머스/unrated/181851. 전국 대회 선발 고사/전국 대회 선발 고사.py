def solution(rank, attendance):
    data = []
    for i in range(len(rank)):
        data.append((rank[i], attendance[i], i))
        
    data.sort(key=lambda x: x[0])
    
    cnt = 2
    answer = 0
    for d in data:
        if cnt == -1:
            return answer
        if d[1]:
            answer += d[2]*(100**cnt)
            cnt -=1
            
    return answer
        
            
            
        