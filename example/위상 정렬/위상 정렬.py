# 방향 그래프의 모든 노드를 방향성에 거스르지 않도록 순서대로 나열하는 것
# 각각 노드의 진입차수(b에 대해a->b 일 경우 a들의 수)가 0인 것들을 큐에 계속 넣고 연결된 간선을 제거

import sys
from collections import deque
input = sys.stdin.readline

v, e = map(int, input().split())
# 모든 노드에 대한 진입차수 0으로 초기화
indegree = [0]*(v+1)
graph = [[] for _ in range(v+1)]

for _ in range(e):
    a, b = map(int, input().split())
    # a -> b 이동
    graph[a].append(b)
    # 진입차수 1 증가
    indegree[b] += 1


def topology_sort():
    # 위상 정렬 함수
    result = []
    q = deque()

    for i in range(1, v+1):
        if indegree[i] == 0:
            q.append(i)

    # 큐가 빌 때까지 반복
    while q:
        now = q.popleft()
        result.append(now)
        for i in graph[now]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)

    for i in result:
        print(i, end=" ")


topology_sort()
