def solution(board, moves):
    l = len(board)
    stack = []
    for i in range(l):
        tmp = []
        for j in range(l-1, -1, -1):
            if board[j][i] != 0:
                tmp.append(board[j][i])
        
        stack.append(tmp)
    print(stack)
    resultStack = []
    result = 0
    for m in moves:
        if not stack[m-1]:
            continue
        v = stack[m-1].pop()
        if resultStack and resultStack[-1] == v:
            resultStack.pop()
            result += 2
        else:
            resultStack.append(v)
    
    return result