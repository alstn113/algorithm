def solution(q, r, code):
    answer = ""
    for idx, v in enumerate(code):
        if idx%q == r:
            answer += v
    return answer