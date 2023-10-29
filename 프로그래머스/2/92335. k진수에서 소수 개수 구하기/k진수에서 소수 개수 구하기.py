def is_prime(n):
    if n <= 1:
        return False
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True


def alter(n, k):
    tmp = ""
    while n > 0:
        v, d = divmod(n, k)
        n = v
        tmp += str(d)
    return tmp[::-1]


def solution(n, k):
    answer = 0
    n = alter(n, k)
    n = n.split("0")
    for v in n:
        if v == "":
            continue
        if is_prime(int(v)):
            answer += 1
    return answer