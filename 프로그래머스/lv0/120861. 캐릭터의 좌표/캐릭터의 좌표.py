def solution(keyinput, board):
    control = {"left": [-1, 0], "right": [1, 0], "up": [0,1], "down": [0,-1]}
    p = [0, 0]
    
    for k in keyinput:
        nx = p[0] + control[k][0]
        ny = p[1] + control[k][1]
        a = board[0]//2
        b = board[1]//2
        if not (-a<=nx<=a and -b<=ny<=b):
            continue
        else:
            p = [nx, ny]
            
    return p
