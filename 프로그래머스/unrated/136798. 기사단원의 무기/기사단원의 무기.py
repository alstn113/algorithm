def divisor(n, limit, power):
    cnt = 0 
    for i in range(1, int(n**0.5)+1):
        if i*i == n:
            cnt += 1
        elif n%i == 0:
            cnt += 2
        
        if cnt > limit:
            return power
    return cnt
    
def solution(number, limit, power):
    result = 0
    for i in range(1, number+1):
        d = divisor(i, limit, power)
        result += d
        
    return result
        