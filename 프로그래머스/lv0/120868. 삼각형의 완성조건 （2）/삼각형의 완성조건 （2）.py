def solution(sides):
    sides.sort()

    cnt = 0
    
    a = (sides[0] + sides[1]) - sides[1] - 1
    b = sides[0]
    
    print(a+b)
    
    return a+b
        