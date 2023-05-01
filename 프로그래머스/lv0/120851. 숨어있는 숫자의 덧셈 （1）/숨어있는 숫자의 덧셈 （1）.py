def solution(my_string):
    cnt = 0
    for i in my_string:
        if i in "0123456789":
            cnt += int(i) 
    return cnt