def dfs(n, start, end, mid):
    global result
    
    if n == 1:
        return result.append([start, end])
    dfs(n-1, start, mid, end)
    result.append([start, end])
    dfs(n-1, mid, end, start)


def solution(n):
    global result
    result = []
    dfs(n, 1, 3, 2)
    return result