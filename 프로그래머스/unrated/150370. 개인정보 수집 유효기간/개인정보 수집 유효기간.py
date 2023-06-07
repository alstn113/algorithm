def parseDate(date):
    year,month,day = date.split(".")
    return int(year)*12*28 + int(month)*28 + int(day)
    

def solution(today, terms, privacies):
    result = []
    dic = {}
    for t in terms:
        a, b = t.split(" ")
        dic[a] = int(b)
        
    today = parseDate(today)
    for idx, value in enumerate(privacies):
        a, b = value.split(" ")
        c = parseDate(a) + 28*dic[b]
        if today > c-1:
            result.append(idx+1)
    return result