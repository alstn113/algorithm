def solution(babbling):
    answer = 0
    data = ["aya", "ye", "woo", "ma"]

    for b in babbling:
        check = -1

        while True:
            if b == "":
                answer += 1
                break

            flag = False
            for idx, value in enumerate(data):
                if check != idx and b.startswith(value):
                    check = idx
                    b = b[len(value):]
                    flag = True

            if not flag:
                break
    return answer
