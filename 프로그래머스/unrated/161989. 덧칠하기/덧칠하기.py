def solution(n, m, section):
    tmp = section[0]
    i = 1
    result = 1
    while i < len(section):
        if section[i] - tmp >= m:
            tmp = section[i]
            result += 1
        i += 1
    
    return result
            
            
        
        
        
        