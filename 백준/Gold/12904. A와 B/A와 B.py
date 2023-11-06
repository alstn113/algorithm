import sys
input = sys.stdin.readline

S = input().rstrip()
T = list(input().rstrip())

while len(S) != len(T):
    if T.pop() == "B":
        T = T[::-1]

print(int(S == "".join(T)))
