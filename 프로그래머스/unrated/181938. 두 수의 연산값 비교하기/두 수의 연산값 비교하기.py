def solution(a, b):
    q = int(str(a)+str(b)) 
    w = 2*a*b
    return q if q>w else w
    