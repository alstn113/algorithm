def solution(arr, queries):
    for q in queries:
        s, e = q
        for i in range(s,e+1):
            arr[i] += 1
            
    return arr