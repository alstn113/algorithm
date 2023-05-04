def solution(i, j, k):
    answer = 0
    for v in range(i,j+1):
        answer += str(v).count(str(k))
    return answer
            