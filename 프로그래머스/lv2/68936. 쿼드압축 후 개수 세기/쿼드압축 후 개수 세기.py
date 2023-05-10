def dfs(arr, x, y, l):
    start = arr[x][y]
    global zero
    global one
    
    for i in range(x, x+l):
        for j in range(y, y+l):
            if arr[i][j] != start:
                half_l = l//2
                dfs(arr, x, y, half_l)
                dfs(arr, x+half_l, y, half_l)
                dfs(arr, x, y+half_l, half_l)
                dfs(arr, x+half_l, y+half_l, half_l)
                return
            
    if start == 0:
        zero += 1
    else:
        one += 1
            
    return

def solution(arr):
    global zero
    global one
    zero = 0
    one = 0
    
    dfs(arr, 0,0, len(arr))
    
    return [zero, one]