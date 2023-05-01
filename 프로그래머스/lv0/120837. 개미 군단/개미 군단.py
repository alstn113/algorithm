def solution(hp):
    answer = 0
    a = hp//5
    b = hp%5
    c = b//3
    d = b%3
    answer = a + c + d
    return answer