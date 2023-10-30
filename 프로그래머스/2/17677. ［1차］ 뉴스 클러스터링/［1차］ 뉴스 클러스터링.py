def solution(str1, str2):
    s1 = [str1[i:i+2].lower()
          for i in range(len(str1)-1) if str1[i:i+2].isalpha()]
    s2 = [str2[i:i+2].lower()
          for i in range(len(str2)-1) if str2[i:i+2].isalpha()]

    intersection = set(s1) & set(s2)
    union = set(s1) | set(s2)

    if len(union) == 0:
        return 65536

    m_intersection = sum([min(s1.count(i), s2.count(i)) for i in intersection])
    m_union = sum([max(s1.count(u), s2.count(u)) for u in union])

    return int(65536 * (m_intersection / m_union))
