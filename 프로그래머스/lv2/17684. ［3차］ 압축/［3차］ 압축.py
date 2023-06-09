def solution(msg):
    result = []
    idx = list("0ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    
    s = 0
    e = 0
    
    while e != len(msg):
        if msg[s:e+1] in idx:
            e += 1
        else:
            result.append(idx.index(msg[s:e]))
            idx.append(msg[s:e+1])
            s = e
    result.append(idx.index(msg[s:e]))
    return result