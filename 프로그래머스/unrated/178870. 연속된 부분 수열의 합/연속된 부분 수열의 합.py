def solution(sequence, k):
    N = len(sequence)
    end = 0
    s = 0
    result = []
    for start in range(N):
        while end < N:
            if s >= k:
                break
            s += sequence[end]
            end += 1
        if s == k:
            if not result:
                result = [start, end - 1]
            else:
                if result[1] - result[0] > end-1 - start:
                    result = [start, end - 1]
        s -= sequence[start]

    return result