def solution(n):
    i = 2
    data = []
    while i<=n:
        if n%i == 0:
            n = n // i
            data.append(i)
        else:
            i += 1
    return sorted(list(set(data)))
            