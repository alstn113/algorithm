def calc(a):
    cnt = 0
    while a != 1:
        if a%2 == 0:
            a //= 2
        else:
            a -= 1
            a //= 2
        cnt += 1
    return cnt
        

def solution(num_list):
    answer = 0
    for num in num_list:
        c = calc(num)
        answer += c
    return answer