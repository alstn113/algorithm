import sys
input = sys.stdin.readline


N, M = map(int, input().split())
graph = [[] for _ in range(N)]
visited = [False]*N

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(v, depth):
    if depth == 5:
        print(1)
        exit(0)
    for i in graph[v]:
        if not visited[i]:
            visited[i] = True
            dfs(i, depth+1)
            visited[i] = False


for i in range(N):
    visited[i] = True
    dfs(i, 1)
    visited[i] = False

print(0)
