# KMP문제인데 알고리즘이 기억이 안난다. 그냥 브루트포스로 감
def solution(myString, pat):
    l = len(pat)
    cnt = 0
    for i in range(len(myString)-l+1):
        if myString[i:i+l] == pat:
            cnt += 1
            
    return cnt