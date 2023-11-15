import sys
input = sys.stdin.readline

N, M = map(int, input().split())
heights = list(map(int, input().split()))
check = [0]*(N+1)

for _ in range(M):
    a, b, k = map(int, input().split())
    check[a-1] += k
    check[b] -= k

accumulated_sum = check[0]
for i in range(1, N+1):
    heights[i-1] += accumulated_sum
    accumulated_sum += check[i]

print(*heights)
