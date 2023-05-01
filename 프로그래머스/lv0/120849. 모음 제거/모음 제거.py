def solution(my_string):
    m = "aeiou"
    answer = ""
    for i in my_string:
        if i in m:
            answer += ""
        else:
            answer += i
    return answer
            