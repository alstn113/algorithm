import heapq


def solution(n, works):
    heap = []
    for work in works:
        # 큰 수가 나오도록 -를 붙여서 추가
        heapq.heappush(heap, -work)

    # 제일 큰 수를 -1씩 해주면서 평평하게 만들어주기
    for _ in range(n):
        # 넣을 때 -를 했으므로 뺄때도 -를 붙이기
        v = - heapq.heappop(heap)
        if v == 0:
            break
        v -= 1
        heapq.heappush(heap, -v)

    answer = 0
    for v in heap:
        answer += (-v)**2

    return answer