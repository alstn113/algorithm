def is_prime(n):
    if n == 1:
        return False
    for i in range(2, int(n**0.5)+1):
        if n%i == 0:
            return False
    return True

def solution(n, k):
    answer = 0
    s = ""
    while n > 0:
        n, mod  = divmod(n, k)
        s = str(mod) + s
    s = s.split("0")
    for v in s:
        if v == "":
            continue
        if is_prime(int(v)):
            answer += 1
    
    return answer