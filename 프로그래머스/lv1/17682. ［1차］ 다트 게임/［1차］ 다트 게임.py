def solution(d):
    result = []
    i = 0
    for _ in range(3):
        # 점수
        tmp = int(d[i])
        i += 1
        if d[i] == "0":
            tmp = 10
            i += 1
            
        
        # 보너스
        if d[i] == "D":
            tmp = tmp**2
        elif d[i] == "T":
            tmp = tmp**3
        i += 1
        
        # [옵션]
        if len(d) != i:
            if d[i] == "*":
                if result:
                    result[-1] *= 2
                tmp *= 2
                i += 1
            elif d[i] == "#":
                tmp *= -1
                i += 1
        print(tmp)
        result.append(tmp)
        
    return sum(result)
            
        
        