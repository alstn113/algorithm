def solution(polynomial):
    polynomial = polynomial.split(' + ')
    print(polynomial)
    
    a = 0
    b = 0
    
    for i in polynomial:
        if 'x' in i:
            if len(i) > 1:
                a += int(i[:-1])
            else:
                a +=1
        else:
            b += int(i)
    
    if a == 0:
        return f'{b}'
    elif a == 1:
        if b == 0:
            return 'x'
        elif b != 0:
            return f'x + {b}'
    elif a > 1:
        if b == 0:
            return f'{a}x'
        elif b != 0:
            return f'{a}x + {b}'