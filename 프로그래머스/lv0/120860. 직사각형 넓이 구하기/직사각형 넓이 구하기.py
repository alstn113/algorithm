def solution(dots):
    a,b,c,d = sorted(dots, key = lambda x: (x[0], x[1]))
    return abs(a[1]-b[1])*abs(b[0]-c[0])
