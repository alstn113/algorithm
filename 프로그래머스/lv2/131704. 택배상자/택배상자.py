def solution(order):
    sub = []
    answer = 0
    
    for i in range(1, len(order)+1):
        sub.append(i)
        while sub and sub[-1] == order[answer]:
            answer += 1
            sub.pop()
            
    return answer