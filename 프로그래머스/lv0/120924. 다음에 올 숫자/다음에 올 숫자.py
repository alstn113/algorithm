def solution(common):
    flag = True # 등차수열
    tmp = 0
    for i in range(0,len(common)-3+1, 3):
        a, b, c = common[i], common[i+1], common[i+2]
        if a + c ==  2*b:
            flag = True
            tmp = b-a
        elif a*c == b**2:
            flag = False
            tmp = b//a
    
    print(flag, tmp)
    
    if flag:
        return common[-1] + tmp
    else:
        return common[-1]*tmp
            
            