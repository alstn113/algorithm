import sys
input = sys.stdin.readline

L, C = map(int, input().split())
data = list(input().split())

m = ["a", "e", "i", "o", "u"]
data.sort()
answer = []


def dfs(s, cnt, idx):
    if cnt == L:
        a = 0
        b = 0
        for i in range(L):
            if s[i] in m:
                a += 1
            else:
                b += 1
        if a >= 1 and b >= 2:
            answer.append(s)
            return

    for i in range(idx, C):
        dfs(s+data[i], cnt+1, i+1)


dfs("", 0, 0)
answer.sort()

for v in answer:
    print(v)
