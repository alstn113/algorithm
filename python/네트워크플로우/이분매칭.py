# 정의
# 이분 매칭이란 a 집단에서 b 집단을 최대로 선택하는 문제
# 참고 자료
# https://www.youtube.com/watch?v=PwXNTA0rpXc&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz&index=33
# 관련 문제
# https://www.acmicpc.net/problem/2188
# https://www.acmicpc.net/problem/11375

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
