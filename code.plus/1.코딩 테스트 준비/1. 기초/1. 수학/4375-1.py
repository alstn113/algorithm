# https://www.acmicpc.net/problem/4375

import sys
input = sys.stdin.readline

# 입력 개수가 명시되지 않았을 때
while True:
    try:
        N = int(input().rstrip())
    except:
        break
    # 여기서 부터 풀면 됨
    i = 1
    n = 1
    while True:
        if n % N == 0:
            print(i)
            break
        n += 10**i
        i += 1


# 정석 풀이
# while True:
#     try:
#         n = int(input())
#     except:
#         break

#     div=0
#     i=1
#     while True:
#         div = div * 10 + 1
#         # 어짜피 앞 부분은 똑같으니까
#         div %= n

#         if div == 0:
#             print(i)
#             break
#         i+=1
