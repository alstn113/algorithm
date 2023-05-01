def solution(array, n):
    return array.count(n)


# 기존 풀이
# 
# def solution(array, n):
#     cnt = 0
#     for i in array:
#         cnt += i == n
#     return cnt