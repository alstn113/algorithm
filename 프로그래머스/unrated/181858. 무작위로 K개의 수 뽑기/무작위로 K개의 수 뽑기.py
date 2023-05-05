def solution(arr, k):
    answer = [arr[0]]
    k -= 1
    for i in range(1, len(arr)):
        if k == 0:
            return answer
        
        if arr[i] not in answer:
            answer.append(arr[i])
            k -=1
    if k == 0:
        return answer
    else:
        return answer + [-1]*k
    