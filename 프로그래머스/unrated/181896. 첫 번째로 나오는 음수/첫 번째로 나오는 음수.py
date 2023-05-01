def solution(num_list):
    for idx, v in enumerate(num_list):
        if v < 0:
            return idx
    return -1
        