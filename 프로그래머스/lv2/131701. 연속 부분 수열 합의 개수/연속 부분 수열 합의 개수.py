def solution(elements):
    result = []
    l = len(elements)
    elements = elements + elements
    # 최대 길이
    for limit in range(1, l+1):
        # 각 인데스 돌기
        for i in range(l):
            result.append(sum(elements[i:i+limit]))
    return len(list(set(result)))