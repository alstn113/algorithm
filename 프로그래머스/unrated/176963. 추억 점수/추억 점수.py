def solution(name, yearning, photo):
    dic = {}
    result = []
    for i in range(len(name)):
        dic[name[i]] = yearning[i]
    
    for p in photo:
        tmp = 0
        for t in p:
            if t in dic:
                tmp += dic[t]
        
        result.append(tmp)
        
    return result
            
        
        