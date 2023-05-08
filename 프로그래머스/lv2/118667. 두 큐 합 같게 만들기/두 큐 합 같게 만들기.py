from collections import deque

def solution(queue1, queue2):
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    
    l = 2*len(queue1)
    
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    
    cnt = 0
    
    while True:
        if cnt > l*2:
            return -1
        if sum1 > sum2:
            t = queue1.popleft()
            queue2.append(t)
            sum1 -= t
            sum2 += t
        elif sum1 < sum2:
            t = queue2.popleft()
            queue1.append(t)
            sum1 += t
            sum2 -= t
        else:
            return cnt
        
        cnt += 1
                
