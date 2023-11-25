import sys
input = sys.stdin.readline
INF = int(1e9)

n,m,r = map(int,input().split())

items = [-1] + list(map(int,input().split()))

distance = [[INF for i in range(n + 1)] for j in range(n + 1)]

for i in range(1,n+1):
    distance[i][i] = 0

for i in range(r):
    a,b,l = map(int,input().split())

    distance[a][b] = l
    distance[b][a] = l

for i in range(1, n + 1):
    for j in range(1, n + 1):
        for k in range(1, n + 1):
            if distance[j][k] > distance[j][i] + distance[i][k]:
                distance[j][k] = distance[j][i] + distance[i][k]

result = 0

for i in range(1,n + 1):
    temp = 0
    for j in range(1, n + 1):
        if distance[i][j] <= m:
            temp += items[j]
    if temp > result:
        result = temp

print(result)