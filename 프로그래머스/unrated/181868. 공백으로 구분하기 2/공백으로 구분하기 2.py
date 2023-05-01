def solution(my_string):
    tmp = ""
    answer = []
    for i in my_string:
        if i == " " and tmp != "":
            answer.append(tmp)
            tmp = ""
        elif i != " ":
            tmp += i
    if tmp != "":
        answer.append(tmp)
    return answer
            
            
            