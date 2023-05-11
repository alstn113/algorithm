def dfs(dungeons, visited, life):
    N = len(dungeons)
    global answer
    
    for i in range(N):
        if visited[i] == 1:
            continue
        if dungeons[i][0] > life:
            continue
        else:
            visited[i] = 1
            dfs(dungeons, visited, life-dungeons[i][1])
            visited[i] = 0
            
    answer = max(answer, sum(visited))
    
def solution(k, dungeons):
    N = len(dungeons)
    visited=[0]*N
    global answer
    answer = 0
    
    for i in range(N):
        dfs(dungeons, visited, k)
    
    return answer
    
        
        