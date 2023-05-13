def solution(topping):
    answer = 0
    dic = {}
    for t in topping:
        if t not in dic:
            dic[t] = 1
        else:
            dic[t] += 1
    
    dic_len = len(dic)
    b = {}
    b_len = 0
    for t in topping:
        dic[t] -= 1
        if dic[t] == 0:
            dic_len -= 1
        if t not in b:
            b[t] = 1
            b_len += 1
        
        if b_len == dic_len:
            answer += 1
            
    return answer
           