# 조합 문제인 듯

def factorial(n):
    if n == 0 or n == 1:
        return 1
    return factorial(n-1)*n

def solution(balls, share):
    a = factorial(balls)//factorial(share)//factorial(balls-share)
    
    return a
