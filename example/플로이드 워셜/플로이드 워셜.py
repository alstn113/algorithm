# 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구하는 경우

import sys
input = sys.stdin.readline
INF = int(1e9)

# 노드와 간선의 개수
n, m = map(int, input().split())
# 각 노드와 노드의 거리를 2차원 배열로 나타냄
graph = [[INF]*(n+1) for _ in range(n+1)]

# 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            graph[i][j] = 0

# 각 간선 정보 받고 비용 초기화
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = c

# 특정 노드를 거치는 거리와 그냥 거리를 비교해서 초기화
for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

for a in range(1, n+1):
    for b in range(1, n+1):
        if graph[a][b] == INF:
            print("INF", end=" ")
        else:
            print(graph[a][b], end=" ")
    print()
