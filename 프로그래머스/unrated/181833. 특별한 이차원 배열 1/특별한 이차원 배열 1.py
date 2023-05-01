def solution(n):
    answer = []
    for i in range(n):
        data = [0]*n
        data[i] = 1
        answer.append(data)
    return answer