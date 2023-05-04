def solution(arr):
    i = 0
    stk = []
    while True:
        if i >= len(arr):
            return stk if stk else [-1]
        if not stk:
            stk.append(arr[i])
            i += 1
        elif stk[-1] == arr[i]:
            stk.pop()
            i += 1
        else:
            stk.append(arr[i])
            i += 1