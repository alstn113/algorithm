import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
selected = [0]*(M+1)
visited = [False]*(M+1)

for i in range(1, N+1):
    a = list(map(int, input().split()))
    graph[i] = a[1:]


def dfs(x):
    for t in graph[x]:
        if visited[t]:
            continue
        visited[t] = True

        if selected[t] == 0 or dfs(selected[t]):
            selected[t] = x
            return True

    return False


cnt = 0
for i in range(1, N+1):
    visited = [False]*(M+1)
    if dfs(i):
        cnt += 1

print(cnt)
