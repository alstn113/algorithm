# https://www.acmicpc.net/problem/1753

import heapq
import sys
input = sys.stdin.readline
INF = 1e9

V, E = map(int, input().split())
START = int(input())
graph = [[] for _ in range(V+1)]
distance = [INF]*(V+1)

for i in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


def dijkstra():
    q = []
    distance[START] = 0
    heapq.heappush(q, (0, START))
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist+i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


dijkstra()

for i in range(1, V+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
