# https://www.acmicpc.net/problem/2869

import math
import sys
input = sys.stdin.readline

A, B, V = map(int, input().split())

cnt = 0
remainder = V - A
cnt += 1
if remainder != 0:
    s = A-B
    cnt += math.ceil(remainder/s)

print(cnt)
