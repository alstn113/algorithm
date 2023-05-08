def is_prime(n):
    if n == 1:
        return False
    for i in range(2, int(n**0.5)+1):
        if n%i == 0:
            return False
    return True

def solution(n, k):
    t = ""
    while n > 0:
        n, mod = divmod(n, k)
        t += str(mod)
    
    t = t[::-1].split("0")
    
    result = 0
    for v in t:
        if v != "":
            if is_prime(int(v)):
                result += 1
            
    return result
    