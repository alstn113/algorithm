def solution(array):
    dic = {}
    for i in array:
        if i not in dic:
            dic[i] = 1
        else:
            dic[i] += 1
        
    data = []
    for key, value in dic.items():
        data.append([value, key])
    
    data.sort(key=lambda x: (-x[0]))
    
    print(data)
    
    if len(data) == 1:
        return data[0][1]
    else:
        return data[0][1] if data[0][0] != data[1][0] else -1