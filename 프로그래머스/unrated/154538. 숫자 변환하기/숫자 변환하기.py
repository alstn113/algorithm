from collections import deque

def solution(x, y, n):
    dp = [0]*(y+1)
    q = deque([x])
    
    if x == y:
        return 0
    
    while q:
        v = q.popleft()
        for i in range(3):
            if i == 0:
                nv = v*2
            elif i == 1:
                nv = v*3
            else:
                nv = v+n
            
            if nv > y:
                continue
            if dp[nv]:
                continue
                
            if nv == y:
                return dp[v]+1
        
            q.append(nv)
            dp[nv] = dp[v]+1
    
    return -1