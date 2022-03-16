from itertools import permutations
import sys
input = sys.stdin.readline

N = int(input())
arr = [i for i in range(1, N+1)]

for v in list(permutations(arr)):
    print(" ".join(map(str, v)))
