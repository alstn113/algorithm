def solution(array, n):
    answer = 1e9
    d = 1e9
    for i in array:
        if abs(n - i) <= d:
            if abs(n-i) == d and answer < i:
                continue
            answer = i
            d = abs(n-i)
    return answer
