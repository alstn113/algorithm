def solution(arr, flag):
    answer = []
    for idx, f in enumerate(flag):
        if f:
            answer += [arr[idx]]*2*arr[idx]
        else:
            for i in range(arr[idx]):
                if answer:
                    answer.pop()
    
    return answer
        