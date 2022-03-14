# https://www.acmicpc.net/problem/17427

import sys
input = sys.stdin.readline

data = []
for i in range(9):
    a = int(input())
    data.append(a)

v = sum(data)-100


def solution():
    for i in range(8):
        for j in range(i+1, 9):
            if data[i]+data[j] == v:
                data.remove(data[j])
                data.remove(data[i])
                return


solution()

data.sort()
for i in data:
    print(i)
