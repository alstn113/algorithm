def solution(array, n):
    cnt = 0
    for i in array:
        cnt += i == n
    return cnt