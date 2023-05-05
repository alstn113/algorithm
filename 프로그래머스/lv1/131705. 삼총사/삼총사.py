from itertools import combinations

def solution(number) :
    cnt = 0
    for c in combinations(number,3) :
        if sum(c) == 0 :
            cnt += 1
    return cnt

# def dfs(number, data):
#     global cnt

#     if len(data) == 3 and sum(data) == 0:
#         cnt += 1
#         return

#     for i in range(len(number)):
#         dfs(number[i+1:], data+[number[i]])


# def solution(number):
#     global cnt
#     cnt = 0

#     dfs(number, [])

#     return cnt