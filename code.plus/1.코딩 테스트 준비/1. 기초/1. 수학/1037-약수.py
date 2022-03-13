# https://www.acmicpc.net/problem/1037

import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))

print(max(data)*min(data))
