def solution(number):
    a = 0
    for i in range(len(number)):
        a += int(number[i])
    return a%9