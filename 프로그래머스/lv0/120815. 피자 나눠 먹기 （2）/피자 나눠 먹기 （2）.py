def solution(n):
    i = 1
    while True:
        if 6*i%n == 0:
            return i
        i += 1
    return i

