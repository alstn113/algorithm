def solution(n):
    answer = [n]
    while True:
        if answer[-1] == 1:
            return answer
        if answer[-1]%2 == 0:
            answer.append(answer[-1]//2)
        else:
            answer.append(answer[-1]*3+1)
    