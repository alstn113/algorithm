import math
import sys
input = sys.stdin.readline

N = int(input())

# 1부터 N의 제곱근까지로 약수의 합 구하기


def divisor(n):
    sum = 0
    for i in range(1, int(math.sqrt(n))+1):
        if i*i == N:
            sum += i
        elif n % i == 0:
            sum += i+n//i
    return sum


print(divisor(N))
