def solution(intStrs, k, s, l):
    answer = []
    for st in intStrs:
        q = st[s:s+l]
        if int(q) > k:
            answer.append(int(q))
    return answer