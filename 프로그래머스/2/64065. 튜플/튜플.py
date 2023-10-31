from collections import Counter


def solution(s):
    s = s.replace('{', '').replace('}', '')
    s = s.split(',')
    s = map(int, s)

    c = Counter(s)
    c = list(c.items())
    c.sort(key=lambda x: -x[1])
    c = [v[0] for v in c]

    return c