import sys
import heapq
input = sys.stdin.readline
INF = 1e9

N, M, K, X = map(int, input().split())
graph = [[] for _ in range(N+1)]
distance = [INF]*(N+1)

for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + 1
            if cost < distance[i]:
                distance[i] = cost
                heapq.heappush(q, (cost, i))


dijkstra(X)


result = [i for i in range(1, N+1) if distance[i] == K]
if result:
    for node in result:
        print(node)
else:
    print(-1)
