from itertools import combinations

def solution(relation):
    l = len(relation[0])
    data = []
    for i in range(1,l+1):
        a = [v for v in range(l)]
        data += list(combinations(a,i)) 
    
    result = []
    for d in data:
        # 여기는 최소성 체크
        flag = False
        for r in result:
            if set(r) | set(d) == set(d):
                flag = True
                break
        if flag:
            continue
        
        # 여기는 유일성 체크
        b = []
        for i in range(len(relation)):
            tmp = []
            for j in d:
                tmp.append(relation[i][j])
            tmp = " ".join(tmp)
            b.append(tmp)
        
        if len(b) == len(list(set(b))):
            result.append(d)
    
    return len(result)
            