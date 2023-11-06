import sys
input = sys.stdin.readline

length, width = map(int, input().split())
paper = [[0 for i in range(width)] for j in range(length)]

for i in range(length):
    paper[i] = list(map(int, input().split()))

ans = 0
for i in range(length):
    for j in range(width):
    
    # □□□□ 모양의 테트로미노의 가능한 경우의 수    
        # 가로로 길게 배치
        if j+3 < width:
            tmp = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i][j+3]
            if ans < tmp: ans = tmp
        
        # 세로로 길게 배치
        if i+3 < length:
            tmp = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+3][j]
            if ans < tmp: ans = tmp

        # □□ 
        # □□ 모양의 테트로미노의 가능한 경우의 수
        if i+1 < length and j+1 < width:
            tmp = paper[i][j] + paper[i+1][j] + paper[i][j+1] + paper[i+1][j+1]
            if ans < tmp: ans = tmp

    # □□□ 
    #  □  모양의 테트로미노의 가능한 경우의 수
        if j+2 < width:
            tmp = paper[i][j] + paper[i][j+1] + paper[i][j+2]
            if i-1 >= 0:
                tmp2 = tmp + paper[i-1][j+1]
                if ans < tmp2: ans = tmp2
            if i+1 < length:
                tmp2 = tmp + paper[i+1][j+1]
                if ans <tmp2: ans = tmp2

        if i+2 < length:
            tmp = paper[i][j] + paper[i+1][j] + paper[i+2][j]
            if j+1 < width:
                tmp2 = tmp + paper[i+1][j+1]
                if ans < tmp2: ans = tmp2
            if j-1 >= 0:
                tmp2 = tmp + paper[i+1][j-1]
                if ans < tmp2: ans = tmp2
    # □
    # □□ 
    #  □  모양의 테트로미노의 가능한 경우의 수
        if i-1 >=0 and j+2 < width:
            tmp = paper[i][j] + paper[i][j+1] + paper[i-1][j+1] + paper[i-1][j+2]
            if ans < tmp: ans = tmp
        if i+1 < length and j+2 < width:
            tmp = paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+1][j+2]
            if ans < tmp: ans = tmp
        if i+2 < length and j+1 < width:
            tmp = paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+2][j+1]
            if ans < tmp: ans = tmp
        if i+2 < length and j-1 >= 0:
            tmp = paper[i][j] + paper[i+1][j] + paper[i+1][j-1] + paper[i+2][j-1]
            if ans < tmp: ans = tmp
    # □
    # □ 
    # □□ 모양의 테트로미노의 가능한 경우의 수
        if i+2 < length and j+1 < width:
            tmp = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+2][j+1]
            if ans < tmp: ans = tmp
        if i+2 < length and j-1 >= 0:
            tmp = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+2][j-1]
            if ans < tmp: ans = tmp
        if i-1 >= 0 and j+2 < width:
            tmp = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i-1][j+2]
            if ans < tmp: ans = tmp
        if i+1 < length and j+2 < width:
            tmp = paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j+2]
            if ans < tmp: ans = tmp
        if i-1 >= 0 and j+2 < width:
            tmp = paper[i][j] + paper[i-1][j] + paper[i-1][j+1] + paper[i-1][j+2]
            if ans < tmp: ans = tmp
        if i+1 < length and j+2 < width:
            tmp = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+2]
            if ans < tmp: ans = tmp
        if i+2 < length and j-1 >= 0:
            tmp = paper[i][j] + paper[i][j-1] + paper[i+1][j-1] + paper[i+2][j-1]
            if ans < tmp: ans = tmp
        if i+2 < length and j+1 < width:
            tmp = paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j+1]
            if ans < tmp: ans = tmp

print(ans)