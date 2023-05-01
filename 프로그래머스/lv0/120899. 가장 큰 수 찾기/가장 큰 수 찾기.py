def solution(array):
    idx = 0
    v = array[0]
    for i in range(len(array)):
        if v < array[i]:
            idx = i
            v = array[i]
            
    return [v, idx]
            