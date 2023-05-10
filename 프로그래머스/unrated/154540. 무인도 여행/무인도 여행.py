import sys
sys.setrecursionlimit(10**5)

def dfs(maps, visited, x, y):
    R = len(maps)
    C = len(maps[0])
    
    visited[x][y] = True
    cnt = int(maps[x][y])
    
    for d in ((0, -1), (0, 1), (1, 0), (-1, 0)):
        nx = x + d[0]
        ny = y + d[1]
        
        if not (0<=nx<R and 0<=ny<C):
            continue
        
        if visited[nx][ny]:
            continue
        
        if maps[nx][ny] == "X":
            continue
            
        cnt += dfs(maps, visited, nx, ny)
    
    return cnt

def solution(maps):
    R = len(maps)
    C = len(maps[0])
    visited=[[False]*C for _ in range(R)]
    
    answer = []
    
    for i in range(R):
        for j in range(C):
            if maps[i][j] == "X":
                continue
            if not visited[i][j]:
                answer.append(dfs(maps, visited, i, j))
    answer.sort()
    
    if not answer:
        return [-1]
    else:
        return answer