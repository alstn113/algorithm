def solution(dots):
    dots.sort(key = lambda x: (x[0], x[1]))
    
    a = (dots[0][1] - dots[1][1]) / (dots[0][0] - dots[1][0])
    b = (dots[2][1] - dots[3][1]) / (dots[2][0] - dots[3][0])
    
    if a == b:
        return 1
    return 0
    
    