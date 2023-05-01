def solution(n):
    i = 1
    factorial = 1
    while True:
        if n < factorial:
            return i-1
        i += 1
        factorial *= i

    
    