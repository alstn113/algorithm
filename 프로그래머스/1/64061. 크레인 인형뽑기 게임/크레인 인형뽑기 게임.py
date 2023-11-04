def solution(board, moves):
    stack = []
    answer = 0
    for move in moves:
        for i in range(len(board)):
            v = board[i][move-1]
            if v != 0:
                if stack and stack[-1] == v:
                    stack.pop()
                    answer += 2
                else:
                    stack.append(v)
                board[i][move-1] = 0
                break
    return answer
