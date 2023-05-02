def solution(s):
    answer = 0
    s = s.split()
    for idx, v in enumerate(s):
        if v == "Z":
            answer -= int(s[idx-1])
        else:
            answer += int(v)
            
    return answer
            
            
        