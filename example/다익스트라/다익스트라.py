import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

# 노드, 간선의 개수
n, m = map(int, input().split())

start = int(input())
graph = [[] for _ in range(n+1)]
distance = [INF]*(n+1)

# 간선 정보 입력 받기 (a노드 -> b노드 c거리)
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        # 거리가 작은 순으로 가는데 이미 처리가 됐으면 무시
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 노드 중 거리가 더 짧아지면 갱신
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


dijkstra(start)

for i in range(1, n+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
