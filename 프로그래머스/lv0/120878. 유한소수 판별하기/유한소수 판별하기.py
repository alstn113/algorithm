def gcd(n, m):
    if m == 0:
        return n
    return gcd(m, n%m) if n>m else gcd(n, m%n)

def solution(a, b):
    b = b // gcd(a,b)
    
    i = 2
    data = []
    while i <= b:
        if b%i == 0:
            b = b // i
            if i not in data:
                data.append(i)
        else:
            i += 1
    print(data)
    if data == [] or data == [5,2] or data == [2,5] or data == [2] or data == [5]:
        return 1
    return 2