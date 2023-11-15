import sys
input = sys.stdin.readline

H, W = map(int, input().split())
heights = list(map(int, input().split()))

result = 0
stack = []

for i in range(W):
    while stack and heights[i] > heights[stack[-1]]:
        top = stack.pop()

        if not stack:
            break

        distance = i - stack[-1] - 1
        bounded_height = min(heights[i], heights[stack[-1]]) - heights[top]
        result += distance * bounded_height

    stack.append(i)

print(result)
