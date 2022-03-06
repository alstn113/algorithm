# https://www.acmicpc.net/problem/4153

import math
import sys
input = sys.stdin.readline

while True:
    arr = list(map(int, input().split()))
    if arr == [0, 0, 0]:
        break
    arr.sort()
    if math.pow(arr[0], 2)+math.pow(arr[1], 2) == math.pow(arr[2], 2):
        print("right")
    else:
        print("wrong")
