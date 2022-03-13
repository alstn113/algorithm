# https://www.acmicpc.net/problem/10430

import sys
input = sys.stdin.readline

a, b, c = map(int, input().split())

print((a+b) % c)
print((a+b) % c)
print((a*b) % c)
print((a*b) % c)

# 출력 1번과 2번, 3번과 4번이 같음을 생각하게 하는 문제인 듯?
