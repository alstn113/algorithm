def dfs(x, y, place, distance, visited):
    if distance == 2:
        return False
    
    for (dx, dy) in ((0,1), (0,-1), (-1,0), (1,0)):
        nx = x + dx
        ny = y + dy
        
        if not(0<=nx<5 and 0<=ny<5):
            continue
        
        if place[nx][ny] == "X":
            continue
            
        if place[nx][ny] == "P" and not visited[nx][ny]:
            return True
        
        if dfs(nx, ny, place, distance+1, visited):
            return True
    
    return False
        
        
        
        

def solution(places):
    answer = []
    for place in places:
        visited = [[False]*5 for _ in range(5)]
        flag = False
        for i in range(5):
            for j in range(5):
                if place[i][j] == "P":
                    visited[i][j] = True
                    if dfs(i,j,place,0, visited):       
                        flag = True 
                        break
            if flag:
                break
        
        v = 0 if flag else 1
        answer.append(v)

    return answer