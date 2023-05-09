import sys
input = sys.stdin.readline

N, S = map(int, input().split())

data = list(map(int, input().split()))

interval_sum = 0
end = 0
min_len = 1e9

for start in range(N):
    while interval_sum < S and end < N:
        interval_sum += data[end]
        end += 1
    if interval_sum >= S:
        min_len = min(min_len, end - start)
    interval_sum -= data[start]  # start 포인터를 옆으로 한 칸 이동

if min_len == 1e9:
    print(0)
else:
    print(min_len)
