def solution(arr, intervals):
    answer = []
    for s, e in intervals:
        answer += arr[s:e+1]
    return answer