def solution(survey, choices):
    dic = {"R": 0, "T":0, "C": 0, "F": 0, "J":0, "M":0, "A":0, "N":0}

    for idx, value in enumerate(choices):
        v = value-4
        if v > 0:
            dic[survey[idx][1]] += v
        else:
            dic[survey[idx][0]] -= v
    
    answer = ""

    answer += "R" if dic["R"] >= dic["T"] else "T"
    answer += "C" if dic["C"] >= dic["F"] else "F"
    answer += "J" if dic["J"] >= dic["M"] else "M"
    answer += "A" if dic["A"] >= dic["N"] else "N"
        
    return answer