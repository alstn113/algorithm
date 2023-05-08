from itertools import combinations

def solution(orders, course):
    result = []
    for c in course:
        dic = {}
        for order in orders:
            order = sorted(list(order))
            comb_list = list(combinations(order, c))
            for comb in comb_list:
                comb = "".join(comb)
                if comb not in dic:
                    dic[comb] = 1
                else:
                    dic[comb] += 1
        dic_list = []
        for key, value in dic.items():
            if value > 1:
                dic_list.append((key, value))
        dic_list.sort(key=lambda x: -x[1])
        
        for i in range(len(dic_list)):
            if dic_list[0][1] == dic_list[i][1]:
                result.append(dic_list[i][0])
            
            
    return sorted(result)