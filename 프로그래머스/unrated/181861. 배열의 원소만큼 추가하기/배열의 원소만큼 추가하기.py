def solution(arr):
    answer = []
    for i in arr:
        answer += [i]*i
    return answer