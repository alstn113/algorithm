def solution(myString, pat):
    l = len(pat)
    myString = myString[::-1]
    pat = pat[::-1]
    for i in range(0, len(myString)-l+1):
        if myString[i:i+l] == pat:
            return myString[i:][::-1]
            
        
        