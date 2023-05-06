def solution(keymap, targets):
    dic = {}
    for k in keymap:
        for idx, value in enumerate(k):
            if value not in dic:
                dic[value] = idx+1  
            elif dic[value] > idx+1:
                dic[value] = idx+1
    
    result = []
    
    for tar in targets:
        tmp = 0
        flag = False
        for i in range(len(tar)):
            if tar[i] not in dic:
                flag = True
                break
            else:
                tmp += dic[tar[i]]
        if flag:
            result.append(-1)
        else:
            result.append(tmp)
    return result
                
        