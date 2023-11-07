from collections import deque
import sys
input = sys.stdin.readline


N, K = map(int, input().rstrip().split())
visited = [False]*100001


if N == K:
    print(0)
elif N > K:
    print(N-K)
else:
    q = deque()
    q.append([N, 0])
    visited[N] = True

    while q:
        x, cnt = q.popleft()
        if x == K:
            print(cnt)
            break
        for nx in (x-1, x+1, x*2):
            if not (100001 > nx >= 0):
                continue
            if visited[nx]:
                continue
            visited[nx] = True
            q.append([nx, cnt+1])
