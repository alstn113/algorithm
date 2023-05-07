def solution(today, terms, privacies):
    dic = {}
    result = []
    
    for t in terms:
        t = t.split()
        dic[t[0]] = int(t[1])
    today = today.split(".")
    today = [int(today[0])*12+int(today[1]), int(today[2])]
    
    for idx, p in enumerate(privacies):
        a, b = p.split()
        a = list(map(int, a.split(".")))
        a = [int(a[0])*12 + a[1]+dic[b], a[2]]
        
        if today[0] > a[0]:
            result.append(idx+1)
        elif today[0] == a[0] and today[1] > a[1]-1:
            result.append(idx+1)
            
    return result
        
    