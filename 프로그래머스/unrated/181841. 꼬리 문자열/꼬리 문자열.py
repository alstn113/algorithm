def solution(str_list, ex):
    answer = ""
    for i in str_list:
        if ex not in i:
            answer += i            
    return answer