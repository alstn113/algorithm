# https://www.acmicpc.net/problem/1065

import sys
input = sys.stdin.readline

N = int(input())
cnt = 0

for num in range(1, N+1):
    if num < 100:
        cnt += 1
        continue
    d100 = num//100
    d10 = (num % 100)//10
    d1 = num % 10
    if d100+d1 == d10*2:
        cnt += 1

print(cnt)
