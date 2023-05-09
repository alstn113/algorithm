from collections import deque

def bfs(s_x, s_y, e_x, e_y, maps):
    R = len(maps)
    C = len(maps[0])

    visited = [[False]*C for _ in range(R)]
    
    q = deque()
    q.append((s_x, s_y, 0))
    visited[s_x][s_y] = True
    
    
    while q:
        x, y, cnt = q.popleft()
            
        if (x, y) == (e_x, e_y):
            return cnt
        
        for d in ((0,1), (0,-1), (1,0), (-1,0)):
            nx = x + d[0]
            ny = y + d[1]
            
            if not (0<=nx<R and 0<=ny<C):
                continue
                
            if visited[nx][ny]:
                continue
            
            if maps[nx][ny] == "X":
                continue
            
            visited[nx][ny] = True
            
            q.append((nx, ny, cnt+1))
            
    return -1

def solution(maps):
    R = len(maps)
    C = len(maps[0])

    visited = [[False]*C for _ in range(R)]
    s_x, s_y = 0, 0
    e_x, e_y = 0, 0
    l_x, l_y = 0, 0

    for i in range(R):
        for j in range(C):
            if maps[i][j] == "S":
                s_x, s_y = i, j
            elif maps[i][j] == "E":
                e_x, e_y = i, j
            elif maps[i][j] == "L":
                l_x, l_y = i, j
    
    cnt = 0
    
    a = bfs(s_x, s_y, l_x, l_y, maps) 
    if a == -1:
        return -1
    else:
        cnt += a
    
    b = bfs(l_x, l_y, e_x, e_y, maps)
    if b == -1:
        return -1
    else:
        cnt += b
        
    return cnt
    