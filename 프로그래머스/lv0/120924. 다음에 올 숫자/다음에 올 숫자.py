def solution(common):
    a, b, c = common[0], common[1], common[2]
    if a + c ==  2*b:
        return common[-1] + b-a
    elif a*c == b**2:
        return common[-1]*(b//a)
    
    
    

            
            