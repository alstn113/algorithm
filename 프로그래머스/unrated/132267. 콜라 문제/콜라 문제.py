def solution(a, b, n):
    answer=0
    while True:
        if n<a:
            return answer
        t = (n//a)*b
        answer += t
        n = t + n%a