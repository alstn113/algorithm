def solution(my_string):
    data = ""
    answer = ""
    for i in my_string:
        if i not in data:
            data += i
            answer += i
    return answer