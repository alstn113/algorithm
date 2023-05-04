def solution(num, total):
    a = [ i for i in range(num)]
    b = sum(a)
    
    c = (total - b) // num 
    print(c)
    for i in range(len(a)):
        a[i] += c
        
    return a