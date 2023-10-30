def make_two_english_letters_list(s: str):
    result = []
    for i in range(len(s)-1):
        v = s[i:i+2]
        if v.isalpha():
            result.append(v.lower())
    return result


def make_jacard_intersection(s1, s2, intersection):
    result = 0
    for v in intersection:
        result += min(s1.count(v), s2.count(v))
    return result


def make_jacard_union(s1, s2, union):
    result = 0
    for v in union:
        result += max(s1.count(v), s2.count(v))
    return result


def solution(str1, str2):
    BIG_NUM = 65536
    s1 = make_two_english_letters_list(str1)
    s2 = make_two_english_letters_list(str2)
    intersection = set(s1) & set(s2)
    union = set(s1) | set(s2)

    if len(union) == 0:
        return BIG_NUM

    jacard_intersection = make_jacard_intersection(s1, s2, intersection)
    jacard_union = make_jacard_union(s1, s2, union)

    return int(BIG_NUM * (jacard_intersection / jacard_union))
