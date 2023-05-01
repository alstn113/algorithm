# 최대 공약수 / 유클리드 호재법
def gcd(n, m):
    if m == 0:
        return n
    return gcd(m, n % m) if n > m else gcd(n, m % n);

    
    
def solution(numer1, denom1, numer2, denom2):
    answer = [denom1*numer2+denom2*numer1, denom1*denom2]
    g = gcd(answer[0], answer[1])
    return [answer[0]//g, answer[1]//g]
    

