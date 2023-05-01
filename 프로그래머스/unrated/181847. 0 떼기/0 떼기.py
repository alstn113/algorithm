def solution(n_str):
    answer = ""
    for idx, k in enumerate(n_str):
        if k != "0":
            return n_str[idx:]
