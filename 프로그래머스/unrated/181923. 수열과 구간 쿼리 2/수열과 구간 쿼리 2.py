def solution(arr, queries):
    result = []
    for q in queries:
        s,e,k = q
        answer = []
        for i in arr[s:e+1]:
            if i > k:
                answer.append(i)
        if not answer:
            result.append(-1)
        else:
            result.append(min(answer))
    return result
                
            