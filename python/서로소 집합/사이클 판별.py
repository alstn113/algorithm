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


# 노드와 간선(union 연산)의 개수 입력받기
v, e = map(int, input().split())
parent = [i for i in range(v+1)]

# 부모를 자기 자신으로 초기화
for i in range(1, v+1):
    parent[i] = i

cycle = False

for i in range(e):
    a, b = map(int, input().split())
    if find_parent(parent, a) == find_parent(parent, b):
      # 이미 부모 노드가 같다는 건 3개 이상 연결되어서 사이클이 돈다는 의미
        cycle = True
        break
    else:
        union_parent(parent, a, b)
