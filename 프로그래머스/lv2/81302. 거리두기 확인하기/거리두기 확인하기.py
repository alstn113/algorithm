def dfs(x, y, place):
    for (dx, dy) in ((0,1), (0,-1), (-1,0), (1,0)):
        nx = x + dx
        ny = y + dy
        
        if not(0<=nx<5 and 0<=ny<5) or place[nx][ny] == "X":
            continue
            
        if place[nx][ny] == "P":
            return True
            
        for (tx, ty) in ((0,1), (0,-1), (-1,0), (1,0)):
            n2x = nx + tx
            n2y = ny + ty
            
            if dx+tx == 0 and dy+ty == 0:
                continue
            if not(0<=n2x<5 and 0<=n2y<5) or place[nx][ny] == "X":
                continue
            
            if place[n2x][n2y] == "P":
                return True
            
    return False
        
        
        
        

def solution(places):
    answer = []
    for place in places:
        flag = False
        for i in range(5):
            for j in range(5):
                if place[i][j] == "P":
                    if dfs(i,j,place):       
                        flag = True 
                        break
            if flag:
                break
        
        v = 0 if flag else 1
        answer.append(v)

    return answer