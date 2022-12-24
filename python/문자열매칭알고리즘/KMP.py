# 참고 https://bowbowbow.tistory.com/6
# 참고 https://www.youtube.com/watch?v=yWWbLrV4PZ8
# 문제 https://www.acmicpc.net/problem/1786
#
# kmp는 문자열 검색 알고리즘이다.
# 텍스트의 길이를 N, 패턴의 길이를 M이라 가정하자.
# 일반적인 탐색으로는 시간 복잡도는 각 텍스트의 인덱스에 대해 패턴이 일치하는지 비교하므로 O(NM)입니다.
#
# KMP 알고리즘은 시간 복잡도를 O(N+M)으로 줄일 수 있습니다.
# pi배열은 pi[i]는 주어진 문자열의 1~i+1 까지의 부분 문자열 중에서 
# prefix(접두사) == suffix(접미사)가 될 수 있는 부분 문자열 중에서 가장 긴 것의 길이
#
# pi를 찾는데 걸리는 시간복잡도는 O(M^3)이지만 kmp를 여기에도 적용하면 O(M)이다.

def getPi(p):
    m = len(p)
    pi = [0] * m
    j = 0
    for i in range(1, m):
        while j > 0 and p[i] != p[j]:
            j = pi[j-1]
        if p[i] == p[j]:
            j += 1
            pi[i] = j
    return pi

def kmp(t, p):
    n = len(t)
    m = len(p)
    pi = getPi(p)
    j = 0
    for i in range(n):
        while j > 0 and t[i] != p[j]:
            j = pi[j-1]
        if t[i] == p[j]:
            if j == m-1:
                arr.append(i-m+2)
                j = pi[j]
            else:
                j += 1
  
if __name__ == "__main__":
    arr = []
    t = "ABC ABCDAB ABCDABCDABDE"
    p = "ABCDABD"
    kmp(t, p)
    print(len(arr))
    print(*arr)



