def solution(arr):
    a = 1
    while True:
        if len(arr) <= a:
            return arr + [0]*(a - len(arr))
        a *= 2
    
