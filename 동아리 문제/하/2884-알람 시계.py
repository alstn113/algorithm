# https://www.acmicpc.net/problem/2884

import sys
input = sys.stdin.readline

H, M = map(int, input().split())

if M-45 < 0:
    M = 60-(45-M)
    if H == 0:
        H = 23
    else:
        H -= 1
    print(H, M)
else:
    print(H, M-45)
