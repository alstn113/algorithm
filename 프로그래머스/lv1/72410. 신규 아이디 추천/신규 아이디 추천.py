def solution(new_id):
    data = list(new_id.lower())
    result = []
    for i in range(len(data)):
        if data[i].isalnum() or data[i] in '-_.':
            if data[i] == '.':
                if result and result[-1] != '.':
                    result.append(data[i])
            else:
                result.append(data[i])
    if result and result[-1] == '.':
        result.pop()
    if not result:
        result.append('a')
    if len(result) >= 16:
        result = result[:15]
        if result[-1] == '.':
            result.pop()
    elif len(result) <= 2:
        while len(result) < 3:
            result.append(result[-1])
    return "".join(result)