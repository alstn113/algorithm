import sys
input = sys.stdin.readline

N, M = map(int, input().split())


def dfs(graph, start):
    if len(graph) == M:
        print(" ".join(map(str, graph)))
        return
    for i in range(start, N+1):
        graph.append(i)
        dfs(graph, i+1)
        graph.pop()


dfs([], 1)
