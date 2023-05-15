def solution(sequence, k):
    N = len(sequence)
    end = 0
    interval_sum = 0
    result = []
    for start in range(N):
        while interval_sum < k and end < N:
            interval_sum += sequence[end]
            end += 1
        if interval_sum == k:
            if not result:
                result = [start, end-1]
            elif result[1]-result[0] > end-1 - start:
                result = [start, end-1]
        interval_sum -= sequence[start]

    return result