def solution(numbers, n):
    s = 0
    for i in numbers:
        s += i
        if s > n:
            return s
        