# 신발끝 공식 참고
import sys

input = sys.stdin.readline

N = int(input())

data = []
result1 = 0
result2 = 0
a1, b1 = map(int, input().split())
data.append([a1, b1])

for i in range(1, N):
    a, b = map(int, input().split())
    data.append([a, b])
    result1 += a*data[i-1][1]
    result2 += b*data[i-1][0]

result1 += a1*data[N-1][1]
result2 += b1*data[N-1][0]

result = round(0.5*abs(result1 - result2), 1)
print(result)
