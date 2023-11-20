import sys

input = sys.stdin.readline


def solution(info, edges):
    max_sheep_count = 1
    N = len(info)
    graph = [[] for _ in range(N)]

    for edge in edges:
        a, b = edge
        graph[a].append(b)

    def dfs(sheep_count, wolf_count, available_nodes):
        nonlocal max_sheep_count

        for node in set(available_nodes):
            next_sheep_count = sheep_count
            next_wolf_count = wolf_count

            if info[node]:
                next_wolf_count += 1
                if next_wolf_count >= sheep_count:
                    continue
            else:
                next_sheep_count += 1
                max_sheep_count = max(max_sheep_count, next_sheep_count)

            next_available_nodes = available_nodes - {node}
            next_available_nodes.update(graph[node])

            dfs(next_sheep_count, next_wolf_count, next_available_nodes)

    dfs(1, 0, set(graph[0]))

    return max_sheep_count