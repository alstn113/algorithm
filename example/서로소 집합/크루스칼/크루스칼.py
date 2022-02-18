# 신장 트리는 하나의 그래프가 모든 노드를 포함하면서 사이클이 존재하지 않는 그래프
# 최소 신장 트리 알고리즘은 모든 노드를 연결하면서 최소 비용인 경우를 찾는 알고리즘
# 크루스칼 알고리즘은 가장 거리가 짧은 간선부터 집합에 포함시키고 사이클이 돌지 않게 함

import sys
input = sys.stdin.readline


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


v, e = map(int, input().split())
parent = [0]*(v+1)
edges = []
result = 0

for i in range(1, v+1):
    parent[i] = i

for _ in range(e):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))


# 가장 작은 비용부터 선택
edges.sort()

for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(result)
