# 깊이 우선 탐색
# v는 시작 노드
def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=" ")
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


graph = [[], [2, 3, 8], [1, 7], [1, 4, 5],
         [3, 5], [3, 4], [7], [2, 6, 8], [1, 7]]
# 각 인덱스에 연결된 노드

visited = [False]*9

dfs(graph, 1, visited)
