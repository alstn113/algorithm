def solution(myString, pat):
    myString = myString.lower()
    pat = pat.lower()
    return 1 if pat in myString else 0