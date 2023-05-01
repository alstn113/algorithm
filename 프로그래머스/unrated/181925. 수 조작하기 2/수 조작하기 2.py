def solution(numLog):
    control = {1:"w", -1: "s", 10: "d", -10: "a"}
    answer = ""
    for i in range(1, len(numLog)):
        a = numLog[i] - numLog[i-1]
        answer += control[a]
        
    return answer