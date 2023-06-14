from itertools import combinations

def solution(relation):
    column = [i for i in range(len(relation[0]))]
    result = []
    
    # 가능한 조합
    comb = []
    for i in range(1, len(column)+1):
        comb += list(combinations(column, i))

    for c in comb:
        # 최소성
        flag = False
        for r in result:
            if set(r) & set(c) == set(r):
                flag = True
                break
        if flag:
            continue
        
        # 유일성
        tmp = []
        flag = False
        for i in range(len(relation)):
            comb_column = " ".join([relation[i][v] for v in c])
            if comb_column not in tmp:
                tmp.append(comb_column)
            else:
                flag = True
                break
        if not flag:
            result.append(c)
    
    return len(result)