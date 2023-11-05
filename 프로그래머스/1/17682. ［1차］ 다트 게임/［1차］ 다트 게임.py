def solution(dartResult):
    score = []
    tmp = 0
    for i in range(len(dartResult)):
        v = dartResult[i]
        if v.isdigit():
            if v == "1":
                if dartResult[i + 1] == "0":
                    tmp = 10
                    i += 1
                    continue
            tmp += int(v)
        elif v in "SDT":
            if v == "D":
                tmp **= 2
            elif v == "T":
                tmp **= 3
            score.append(tmp)
            tmp = 0
        else:
            if v == "*":
                score[-1] *= 2
                if len(score) > 1:
                    score[-2] *= 2
            else:
                score[-1] *= -1
    return sum(score)
