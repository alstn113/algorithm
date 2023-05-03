def solution(order):
    answer = 0
    for o in order:
        if "cafelatte" in o:
            answer += 5000
            continue
        answer += 4500
    return answer