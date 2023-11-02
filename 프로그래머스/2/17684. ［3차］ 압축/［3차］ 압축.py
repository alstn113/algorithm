def solution(msg):
    answer = []
    index_list = list("0ABCDEFGHIJKLMNOPQRSTUVWXYZ")

    tmp = ""
    i = 0
    while i < len(msg):
        tmp += msg[i]
        if tmp in index_list:
            i += 1
            continue
        answer.append(index_list.index(tmp[:-1]))
        index_list.append(tmp)

        tmp = ""
    if tmp in index_list:
        answer.append(index_list.index(tmp))
    return answer