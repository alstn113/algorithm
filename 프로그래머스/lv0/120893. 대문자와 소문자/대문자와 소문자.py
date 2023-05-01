def solution(my_string):
    answer = ""
    for idx, s in enumerate(my_string):
        if s.isupper():
            answer += my_string[idx].lower()
        else:
            answer += my_string[idx].upper()
        
    return answer