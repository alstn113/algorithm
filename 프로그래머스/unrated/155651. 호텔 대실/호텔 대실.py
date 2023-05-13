import heapq


def solution(book_time):
    data = []
    answer = 1

    for b in book_time:
        s = int(b[0][:2])*60+int(b[0][3:])
        e = int(b[1][:2])*60+int(b[1][3:])
        data.append([s, e])

    data.sort()

    h = []
    for b in data:
        if not h:
            heapq.heappush(h, b[1])
            continue
        if h[0] <= b[0]:
            heapq.heappop(h)
        else:
            answer += 1
        heapq.heappush(h, b[1]+10)

    return answer
