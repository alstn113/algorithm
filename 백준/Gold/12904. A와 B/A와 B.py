import sys
input = sys.stdin.readline

S = input().rstrip()
T = list(input().rstrip())

while len(S) != len(T):
    if T.pop() == "B":
        T = T[::-1]

if S == "".join(T):
    print(1)
else:
    print(0)
