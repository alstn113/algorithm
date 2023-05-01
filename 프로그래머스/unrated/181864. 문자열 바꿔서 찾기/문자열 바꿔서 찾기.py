def solution(myString, pat):
    myString = myString.replace("A", "T")
    myString = myString.replace("B", "A")
    myString = myString.replace("T", "B")
        
    return 1 if pat in myString else 0