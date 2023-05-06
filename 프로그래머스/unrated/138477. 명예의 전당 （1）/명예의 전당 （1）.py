def solution(k, score):
    rank = []
    result = []
    for i in score:
        rank.append(i)
        rank.sort(reverse=True)
        rank = rank[:k]
        result.append(rank[-1])
    
    return result