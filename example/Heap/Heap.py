import heapq

# 최대힙(내림차순)


def maxHeapSort(iterable):
    h = []
    result = []
    for value in iterable:
        heapq.heappush(h, -value)
    for _ in range(len(h)):
        result.append(-heapq.heappop(h))
    return result

# 최소힙(오름차순)


def minHeapSort(iterable):
    h = []
    result = []
    for value in iterable:
        heapq.heappush(h, value)  # 넣을 때 반대로
    for _ in range(len(h)):
        result.append(heapq.heappop(h))  # 꺼낼 때 반대로
    return result


maxHeap = maxHeapSort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
print(maxHeap)

minHeap = minHeapSort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
print(minHeap)
