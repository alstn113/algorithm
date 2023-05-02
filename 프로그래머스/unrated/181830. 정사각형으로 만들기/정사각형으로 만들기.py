def solution(arr):
    r, c = len(arr), len(arr[0])
    if r > c:
        for i in range(r):
            arr[i] += ([0]*(r-c))
    elif c > r:
        for i in range(c-r):
            arr.append([0]*c)
    
    return arr