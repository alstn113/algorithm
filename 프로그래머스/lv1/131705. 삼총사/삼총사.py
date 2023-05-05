def dfs(number, data):
    global cnt

    if len(data) == 3 and sum(data) == 0:
        cnt += 1
        return

    for i in range(len(number)):
        dfs(number[i+1:], data+[number[i]])


def solution(number):
    global cnt
    cnt = 0

    dfs(number, [])

    return cnt