# https://www.acmicpc.net/problem/2217

import sys
input = sys.stdin.readline

N = int(input())
rope_list = []
result = 0

for i in range(N):
    rope = int(input())
    rope_list.append(rope)

rope_list.sort(reverse=True)

for i in range(N):
    result = max(result, rope_list[i]*(i+1))

print(result)
