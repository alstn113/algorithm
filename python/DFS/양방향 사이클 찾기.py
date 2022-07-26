# 백준 16947번 서울 지하철 2호선 문제
# 양방향 그래프 dfs로 사이클 찾기 부분 예제
# 출처 : https://velog.io/@embeddedjune/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-DFS-BFS-16947-%EC%84%9C%EC%9A%B8-%EC%A7%80%ED%95%98%EC%B2%A0-2%ED%98%B8%EC%84%A0
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)


N = int(input())
graph = [[] for _ in range(N+1)]
check = [0]*(N+1)
for i in range(N):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# - return 값에 대해서 -
# n>=0 : 사이클을 찾았고, 시작 정점의 번호가 저장됨
# -1 : 사이클을 찾지 못함
# -2 : 사이클은 찾았으나 해당 정점은 사이클에 포함되지 않음


def dfs(cv,  pv):  # 현재 정점, 이전 정점
    print("cv", cv, "pv", pv)
    print(check)
    if check[cv] == 1:
        return cv
    check[cv] = 1

    for nv in graph[cv]:
        if nv == pv:  # 이전 정점으로 돌아가는 경우
            continue
        result = dfs(nv, cv)
        if result == -2:
            return -2
        if result >= 0:
            check[cv] = 2
            if cv == result:
                return -2
            else:
                return result
    return -1


dfs(1, 0)  # 현재 정점 1번, 이전 정점 없으므로 0
print(check)
