def solution(n, t, m, p):
    base = "0123456789ABCDEF"
    data = "0"
    k=1 # 차례대로 말하는 증가하는 수
    
    while len(data) < t*m:
        v = k
        tmp = ""
        while v:
            v, mod = divmod(v, n)
            tmp = base[mod] + tmp
        
        data += tmp
        k += 1
    print(data)
    answer = ""
    for i in range(t):
        answer += data[(p-1)+i*m]
    return answer