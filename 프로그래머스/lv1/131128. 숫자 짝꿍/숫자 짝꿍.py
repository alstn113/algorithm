def solution(X, Y):
    a = [0]*10
    b = [0]*10
    for n in X:
        a[int(n)] += 1
    for n in Y:
        b[int(n)] += 1
    
    
    result = ""
    for i in range(9, 0, -1):
        m = min(a[i], b[i])
        if m != 0:
            result += str(i)*m
    
    m = min(a[0], b[0])
    if result == "":
        if m > 0:
            return "0"
        return "-1"
    return result + "0"*m
