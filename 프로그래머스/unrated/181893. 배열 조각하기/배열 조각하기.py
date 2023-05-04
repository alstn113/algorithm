def solution(arr, query):
    for idx, v in enumerate(query):
        if idx%2 == 0:
            arr = arr[:v+1]
        else:
            arr = arr[v:]
    
    return  arr
        