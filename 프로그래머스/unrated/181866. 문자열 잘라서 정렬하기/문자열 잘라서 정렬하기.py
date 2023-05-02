def solution(myString):
    data =[]
    tmp = ""
    for i in myString:
        if i != "x":
            tmp += i
        elif i == "x" and tmp != "":
            data.append(tmp)
            tmp = ""
            
    if tmp != "":
        data.append(tmp)
    return sorted(data)