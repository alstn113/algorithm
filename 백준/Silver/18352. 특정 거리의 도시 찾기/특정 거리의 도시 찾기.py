import sys
import heapq
input = sys.stdin.readline
INF = 1e9

N, M, K, X = map(int, input().split())
graph = [[] for _ in range(N+1)]
distance = [INF]*(N+1)

for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append((B, 1))


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


dijkstra(X)

cnt = 0
for i in range(len(distance)):
    if distance[i] == K:
        print(i)
        cnt += 1
if cnt == 0:
    print(-1)
