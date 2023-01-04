# 일단 묶는 방법을 구하는 문제
#
# 2422의 경우
# 앞에서부터 3개씩 묶으면 222 0202 해서 총 6개 덩어리가 생김
# 22 0222로 묶으면 총 4개의 덩어리가 생김
#
# 연속된 인덱스 3개 중에 0이 없을 때, 3번째가 2번째보다 작을 경우 2개씩 묶는 방법을 먼저 사용한다.

# * 묶는 거 +1 이 아니라 A[i]번씩 묶어야함 주의!!!! - 이걸로 시간 줮나 날렸네

# * 2432에서 1332가 되면 또 얘기가 달라짐 - ㅠㅠ

import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))+[0, 0]

result = 0
i = -1
while i < len(A)-2:
    i += 1
    # print("step", i, result, A)
    # 인덱스 3개 가지고 놀기

    # ex) 011 or 001 or 000
    if A[i] == 0:
        continue

    # ex) 101 or 100
    if A[i+1] == 0:
        result += A[i]*3
        A[i] = 0
        i += 1
        continue

    # ex) 110
    if A[i+2] == 0:
        if A[i] > A[i+1]:
            # ex) 310
            result += A[i+1]*2*2 + A[i+1] + (A[i]-A[i+1])*3
        else:
            # ex) 130
            result += A[i]*2*2 + A[i] + (A[i+1]-A[i])*3
        A[i] = 0
        A[i+1] = 0
        i += 2
        continue

    # ex) 2422
    if A[i+1] > A[i+2]:
        # 2개 단위로 먼저 계산
        if A[i] > A[i+1]:
            result += 1 * 2 * 2 + 1
            A[i] -= 1
            A[i+1] -= 1
        else:
            result += 1 * 2 * 2 + 1
            A[i+1] -= 1
            A[i] -= 1

    # ex) 2242 / 2222 / 3222
    else:
        # 3개 단위로 계산
        v = min(A[i], A[i+1], A[i+2])

        result += v * 3 * 2 + v

        A[i] -= v
        A[i+1] -= v
        A[i+2] -= v
    i -= 1
    continue

print(result)
