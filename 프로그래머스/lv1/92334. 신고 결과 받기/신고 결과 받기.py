def solution(id_list, report, k):
    dic = {}
    for id in id_list:
        dic[id] = [0, []]
    for r in list(set(report)):
        id, reported_id = r.split(" ")
        dic[reported_id][1].append(id)
    
    for idx, value in dic.items():
        if len(value[1]) >= k:
            for v in value[1]:
                dic[v][0] += 1
    result = []
    for id in id_list:
        result.append(dic[id][0])
        
    return result
        
        