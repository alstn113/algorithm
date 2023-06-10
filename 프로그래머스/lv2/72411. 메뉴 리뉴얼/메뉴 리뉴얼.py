from itertools import combinations

def solution(orders, course):
    result = []
    for c in course:
        dic = {}
        for order in orders:
            order = sorted(list(order))
            comb = list(combinations(order, c))
            for v in comb:
                v = "".join(v)
                if v not in dic:
                    dic[v] = 1
                else:
                    dic[v] += 1
        dic_items = list(dic.items())
        dic_items.sort(key=lambda x: -x[1])
        
        for i in range(len(dic_items)):
            if dic_items[0][1] == dic_items[i][1] and dic_items[i][1] > 1:
                result.append(dic_items[i][0])
            
            
    return sorted(result)