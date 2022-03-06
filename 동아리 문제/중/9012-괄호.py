# https://www.acmicpc.net/problem/9012

import sys
input = sys.stdin.readline

N = int(input())

for i in range(N):
    arr = list(input().rstrip())
    left = 0
    isVPS = True
    for a in arr:
        if a == "(":
            left += 1
        else:
            if left == 0:
                isVPS = False
                break
            else:
                left -= 1

    if left > 0 or not isVPS:
        print("NO")
    else:
        print("YES")
