def solution(strArr):
    for i in range(1, len(strArr), 2):
        strArr[i] = strArr[i].upper()
    for i in range(0, len(strArr), 2):
        strArr[i] = strArr[i].lower()
        
    return strArr
