def solution(a, b):
    q = int(str(a)+str(b))
    w = int(str(b)+str(a))
    return q if q >= w else w