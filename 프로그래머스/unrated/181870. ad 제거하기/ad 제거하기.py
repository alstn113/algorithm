def solution(strArr):
    answer = []
    for s in strArr:
        if "ad" not in s:
            answer.append(s)
            
    return answer
            