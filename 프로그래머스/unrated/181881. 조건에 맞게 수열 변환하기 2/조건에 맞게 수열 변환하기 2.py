def solution(arr):
    i = 0
    while True:
        cnt = 0
        
        for idx, v in enumerate(arr):
            if v >= 50 and v%2 == 0:
                arr[idx] //= 2
            elif v < 50 and v%2 == 1:
                arr[idx] = arr[idx]*2 + 1
            else:
                cnt += 1
        
        if cnt == len(arr):
            return i
        
        i += 1
        
                
        
                