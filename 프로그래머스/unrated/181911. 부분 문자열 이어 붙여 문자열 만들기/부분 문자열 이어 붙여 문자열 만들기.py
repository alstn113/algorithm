def solution(my_strings, parts):
    answer = ''
    for idx, v in enumerate(my_strings):
        s, e = parts[idx]
        answer += v[s:e+1]
        
    return answer