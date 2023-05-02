def solution(emergency):
    s = sorted(emergency, reverse=True)
    result = []
    for i in emergency:
        result.append(s.index(i)+1)
    
    return result
        