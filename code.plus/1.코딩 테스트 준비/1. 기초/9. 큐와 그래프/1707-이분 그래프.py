from collections import deque
import sys
input = sys.stdin.readline


def bfs(start, graph, visited):
    q = deque([start])
    visited[start] = 1

    while q:
        v = q.popleft()

        for i in graph[v]:
            if visited[i] == 0:
                q.append(i)
                visited[i] = -1 * visited[v]
            elif visited[v] == visited[i]:
                return False
    return True


T = int(input())
for t in range(T):
    N, M = map(int, input().split())
    graph = [[] for _ in range(N+1)]
    visited = [0]*(N+1)
    for i in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    isCheck = False
    for k in range(1, N+1):
        if visited[k]:
            continue
        if bfs(k, graph, visited) == False:
            isCheck = True
            break

    if isCheck:
        print("NO")
    else:
        print("YES")
