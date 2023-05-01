def solution(order):
    order = str(order)
    cnt = 0
    for i in order:
        if i in "369":
            cnt += 1
            
    return cnt