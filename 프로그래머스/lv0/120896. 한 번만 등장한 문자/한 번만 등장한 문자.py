def solution(s):
    arr = [0]*26
    for i in s:
        arr[ord(i)-97] += 1
    
    answer = ""
    for idx, v in enumerate(arr):
        if v == 1:
            answer += chr(97+idx)
    
    return answer
            
