from collections import Counter


def solution(N, stages):
    stage_counter = Counter(stages)
    cleared_player = len(stages)
    result = []
    for i in range(1, N+1):
        if stage_counter[i] == 0:
            result.append([i, 0])
        else:
            result.append([i, stage_counter[i]/cleared_player])
        cleared_player -= stage_counter[i]

    result.sort(key=lambda x: -x[1])
    result = list(map(lambda x: x[0], result))

    return result