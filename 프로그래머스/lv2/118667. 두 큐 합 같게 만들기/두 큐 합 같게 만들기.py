from collections import deque

def solution(q1, q2):
    sum_1 = sum(q1)
    sum_2 = sum(q2)
    
    q1 = deque(q1)
    q2 = deque(q2)
    
    l = len(q1)*2
    cnt = 0
    while True:
        if cnt > l+2:
            return -1
        if sum_1 == sum_2:
            return cnt
        if sum_1 > sum_2:
            v = q1.popleft()
            q2.append(v)
            sum_1 -= v
            sum_2 += v     
        else:
            v = q2.popleft()
            q1.append(v)
            sum_2 -= v
            sum_1 += v   
        cnt += 1
