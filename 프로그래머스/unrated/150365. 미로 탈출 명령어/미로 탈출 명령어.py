from collections import deque


def solution(n, m, x, y, r, c, k):
    q = deque()
    q.append([x-1, y-1, ""])

    while q:
        x, y, path = q.popleft()
        if (r-1, c-1) == (x, y) and (k - len(path)) % 2 == 1:
            return "impossible"
        if (x, y) == (r-1, c-1) and len(path) == k:
            return path
        for (dx, dy, t) in ((1, 0, "d"), (0, -1, "l"), (0, 1, "r"), (-1, 0, "u")):
            nx = x + dx
            ny = y + dy

            if not (0 <= nx < n and 0 <= ny < m):
                continue
            
            if abs(r-1 - nx) + abs(c-1 - ny) > k-len(path):
                continue
            
            q.append([nx, ny, path+t])
            
            break

    return 'impossible'


print(solution(3,	4,	2,	3,	3,	1,	5))

# 1차 시도 - 시간 초과

# def solution(n, m, x, y, r, c, k):
#     paths = []

#     def dfs(x, y, path):
#         if abs(r-1-x) + abs(c-1-y) > k - len(path):
#             return
#         if len(path) >= k:
#             if (x, y) == (r-1, c-1):
#                 paths.append(path)
#             return
#         # d l r u
#         for (dx, dy, t) in ((1,0,"d"), (0,-1,"l"), (0,1,"r"), (-1,0,"u")):
#             nx = x + dx
#             ny = y + dy

#             if not (0<=nx<n and 0<=ny<m):
#                 continue

#             dfs(nx, ny, path+t)

#     dfs(x-1, y-1, "")
#     paths.sort()

#     return paths[0] if paths else "impossible"
