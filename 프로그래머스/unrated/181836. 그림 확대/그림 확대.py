def solution(picture, k):
    answer = []
    for i in range(len(picture)):
        tmp = ""
        for j in range(len(picture[0])):
            tmp += picture[i][j]*k
        for i in range(k):
            answer.append(tmp)

    
    return answer
            
            