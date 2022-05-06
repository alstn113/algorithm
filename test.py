import sys
input = sys.stdin.readline

N = int(input())
written = list(map(int, input().split()))
M = int(input())
question = []
for _ in range(M):
    s, e = map(int, input().split())
    question.append((s, e))

# 1 2 1 3 1 2 1

# 일단 2차원 배열로 만들어야하나?
