import sys
input = sys.stdin.readline

N = int(input())

data = [list(map(int, input().split())) for _ in range(N)]
visited = [False] * N
min_value = 1e9


def power_check():
    team1_power = 0
    team2_power = 0
    global min_value
    for i in range(N):
        for j in range(N):
            if i == j:
                continue
            if visited[i] and visited[j]:
                team1_power += data[i][j]
            elif not visited[i] and not visited[j]:
                team2_power += data[i][j]

    min_value = min(min_value, abs(team1_power - team2_power))

    return


def dfs(idx, cnt):
    if N > cnt > 0:
        power_check()

    for i in range(idx, N):
        if not visited[i]:
            visited[i] = True
            dfs(i+1, cnt+1)
            visited[i] = False


dfs(0, 0)
print(min_value)
