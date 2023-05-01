def solution(a, b):
    q = int(a%2 != 0)
    w = int(b%2 != 0)
    
    if q+w == 2:
        return a**2 + b**2
    elif q+w == 1:
        return 2*(a+b)
    else:
        return a-b if a>b else b-a
        