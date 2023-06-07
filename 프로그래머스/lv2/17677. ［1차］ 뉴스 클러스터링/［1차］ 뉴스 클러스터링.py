def make_set(str):
    s = set()
    for i in range(len(str)-1):
        v = str[i:i+2]
        if v.isalpha():
            n = 0
            while (v.lower(), n) in s:
                n += 1
            s.add((v.lower(), n)) # 다중 집합
    return s
    

def solution(str1, str2):
    s1 = make_set(str1)
    s2 = make_set(str2)
    if len(s1 & s2) == 0 and len(s1 | s2) == 0:
        return 65536
    z = len(s1 & s2) / len(s1 | s2)
    return int(z*65536)