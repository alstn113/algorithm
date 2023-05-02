def solution(strArr):
    dic = {}
    for s in strArr:
        l = len(s)
        if l not in dic:
            dic[l] = 1
        else:
            dic[l] += 1
    
    a_value = 0
    for key, value in dic.items():
        if value > a_value:
            a_value = value
            
    return a_value