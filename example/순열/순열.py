import sys
input = sys.stdin.readline

# TODO: 이거 뭔가 이상한듯 고치기

# arr 배열에서 n개를 순서있게 뽑음


def permutation(n, depth, P):
    result = []
    if depth == n:
        return [P]
    else:
        for i in range(len(arr)):
            if chosen[i] == True:
                continue
            chosen[i] = True
            result += permutation(n, depth+1, P+[i])
            chosen[i] = False
    return result


arr = [1, 2, 3]
chosen = [False for _ in range(len(arr))]

# 3개 뽑은 인덱스를 배열로 반환
print(permutation(3, 0, []))
