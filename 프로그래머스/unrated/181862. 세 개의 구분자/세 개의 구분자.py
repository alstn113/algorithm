def solution(myStr):
    myStr = myStr.replace("a", " ").replace("b", " ").replace("c", " ").strip()
    answer = []
    myStr = myStr.split()
    for s in myStr:
        if s != " ":
            answer.append(s)
            
    return answer if answer else ["EMPTY"]
        