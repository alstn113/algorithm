def solution(rsp):
    answer = ""
    dic = { "2": "0", "0": "5", "5": "2" }
    for i in rsp:
        answer += dic[i]
    
    return answer 
        