def solution(array, height):
    cnt = 0
    for i in array:
        if i > height:
            cnt += 1
    return cnt