def solution(k, tangerine):
    dic = {}
    for t in tangerine:
        if t not in dic:
            dic[t] = 1
        else:
            dic[t] += 1
    data = [value for key, value in dic.items()]
    data.sort(reverse=True)
    
    
    result = 0
    i = 0
    while k > result:
        result += data[i]
        i += 1
    
    return i
        