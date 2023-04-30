from itertools import permutations

def solution(babbling):
    data = []
    able_to_say = ["aya", "ye", "woo", "ma"]
    for i in range(1, 4+1):
        for p in list(permutations(able_to_say,i)):
            data.append("".join(p))

    cnt = 0
    for b in babbling:
        if b in data:
            cnt += 1
    return cnt