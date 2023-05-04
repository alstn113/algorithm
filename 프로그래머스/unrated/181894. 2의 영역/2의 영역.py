def solution(arr):
    data = []
    for i in range(len(arr)):
        if arr[i] == 2:
            data.append(i)
    
    if not data:
        return [-1]
    if len(data) == 1:
        return [2]
    return arr[data[0]:data[-1]+1]