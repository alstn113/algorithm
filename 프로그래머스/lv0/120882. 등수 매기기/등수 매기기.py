def solution(score):
    data = []
    for idx, s in enumerate(score):
        data.append([sum(s)/2, idx])
    
    data.sort(key=lambda x: -x[0])
    
    data[0].append(1)
    rank = 2
    for i in range(1, len(data)):
        if data[i-1][0] == data[i][0]:
            data[i].append(data[i-1][2])
        else:
            data[i].append(rank)
        rank += 1
    
    data.sort(key=lambda x: x[1])
    answer = []
    for d in data:
        answer.append(d[2])
    
    return answer
    