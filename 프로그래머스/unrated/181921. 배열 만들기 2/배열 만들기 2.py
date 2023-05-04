def solution(l, r):
    answer = []
    for i in range(l, r+1):
        # 5나 0 이외의 것이 들어가면 continue
        if all(v not in str(i) for v in ["1","2","3","4","6","7","8","9"]):
            answer.append(i)
            
    return answer if answer else [-1]
            