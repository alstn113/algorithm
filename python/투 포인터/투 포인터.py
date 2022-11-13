import sys
input = sys.stdin.readline

n = 5  # 데이터 개수
m = 5  # 찾고자 하는 부분합
data = [1, 2, 3, 4, 5]
count = 0
interval_sum = 0
end = 0

for start in range(n):
    while interval_sum < m and end < n:
        interval_sum += data[end]
        end += 1
    if interval_sum == m:
        count += 1
    interval_sum -= data[start]  # start 포인터를 옆으로 한 칸 이동

print(count)
