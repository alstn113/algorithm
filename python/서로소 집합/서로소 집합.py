# 무방향 그래프 내에서 사이클을  확인 가능
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


for i in range(e):
    a, b = map(int, input().split())
    union_parent(parent, a, b)

print("각 원소가 속한 집합",  end=" ")
for i in range(1, v+1):
    print(find_parent(parent, i), end=" ")

print("부모테이블", end=" ")
for i in range(1, v+1):
    print(parent[i], end=" ")
