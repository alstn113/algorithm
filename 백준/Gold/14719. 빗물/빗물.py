import sys
input = sys.stdin.readline

H, W = map(int, input().split())
heights = list(map(int, input().split()))

result = 0
for i in range(1, W-1):
    left_max = max(heights[:i])
    right_max = max(heights[i+1:])

    lower_one = min(left_max, right_max)

    if heights[i] < lower_one:
        result += lower_one - heights[i]
print(result)
