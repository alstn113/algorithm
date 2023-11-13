from collections import deque
import sys
input = sys.stdin.readline


def topology_sort():
    q = deque()
    for i in range(N):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()
        for i in graph[now]:
            result[i] = max(result[i], result[now]+time[i])
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)


T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    indegree = [0]*N # 진입 차수
    graph = [[] for _ in range(N)]
    time = list(map(int, input().split()))
    result = time[:]

    for _ in range(M):
        x, y = map(int, input().split())
        indegree[y-1] += 1
        graph[x-1].append(y-1)

    target = int(input())

    topology_sort()
    print(result[target-1])
