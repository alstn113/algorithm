# https://www.acmicpc.net/problem/1978

import math
import sys
input = sys.stdin.readline

N = int(input())
question = list(map(int, input().split()))
MAX = max(question)

# 에라토스테네스의 체 이용
arr = [True for _ in range(MAX+1)]
arr[1] = False

for i in range(2, int(math.sqrt(MAX))+1):
    if arr[i] == True:
        j = 2
        while i*j <= MAX:
            arr[i*j] = False
            j += 1

cnt = 0
for q in question:
    if arr[q]:
        cnt += 1

print(cnt)
