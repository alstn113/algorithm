def solution(arr, queries):
    for q in queries:
        s,e,k = q
        for i in range(s, e+1):
            if i%k == 0:
                arr[i] += 1
    return arr
                
            