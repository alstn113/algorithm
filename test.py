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


N, M = map(int, input().split())

parent = [i for i in range(N)]

result = 0
for i in range(M):
    a, b = map(int, input().split())

    if find_parent(parent, a) == find_parent(parent, b):
        result = i+1
        break
    else:
        union_parent(parent, a, b)

print(result)
