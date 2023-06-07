import re
from collections import Counter
def solution(s):
    s= s.replace("{","").replace("}","").split(",")
    c = Counter(s)
    c = list(c.items())
    c.sort(key=lambda x: -x[1])
    c = [int(v[0]) for v in c]

    return c