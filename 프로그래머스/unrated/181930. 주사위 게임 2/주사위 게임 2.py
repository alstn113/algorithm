def solution(a, b, c):
    data = int(a == b) + int(a == c) + int(b == c)
    print(data)
    if data == 1:
        return (a + b + c) * (a**2 + b**2 + c**2)
    elif data == 3:
        return (a + b + c) * (a**2 + b**2 + c**2 ) * (a**3 + b**3 + c**3 )
    else:
        return a+b+c
