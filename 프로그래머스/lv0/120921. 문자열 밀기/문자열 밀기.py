from collections import deque

def solution(A, B):
    a = deque(list(A))
    b = deque(list(B))
    if a == b:
        return 0
    
    for i in range(1, len(A)):
        v = a.pop()
        a.appendleft(v)
        
        print(a,b)
        
        if a == b:
            return i
            
    return -1
        