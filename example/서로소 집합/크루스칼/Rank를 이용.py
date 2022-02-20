# 백준 13905번 세부 문제

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
s_p, e_p = map(int, input().split())
edge = []
for _ in range(M):
    a, b, cost = map(int, input().split())
    edge.append((cost, a, b))

edge.sort(reverse=True)
parent = [i for i in range(N+1)]
rank = [0]*(N+1)


def find_parent(a):
    if parent[a] != a:
        parent[a] = find_parent(parent[a])
    return parent[a]


def union_parent(a, b):
    a, b = find_parent(a), find_parent(b)
    if rank[a] < rank[b]:
        parent[a] = b
    else:
        parent[b] = a
        if rank[a] == rank[b]:
            rank[a] += 1
# Rank 값이 작은 노드의 Parent 값을, Rank 값이 큰 노드의 Parent 값으로 바꿔줌
# Rank 값이 같아지면 parent값이 바뀌지 않은 노드의 Rank 값을 1 증가 시킴


edge.sort(reverse=True)
result = 0
for cost, a, b in edge:
    if find_parent(a) != find_parent(b):
        union_parent(a, b)
    if find_parent(s_p) == find_parent(e_p):
        result = cost
        break

if find_parent(s_p) == find_parent(e_p):
    print(result)
else:
    print(0)
