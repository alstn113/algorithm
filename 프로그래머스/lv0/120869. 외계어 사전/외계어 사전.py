def solution(spell, dic):
    flag = False
    for d in dic:
        sub_flag = True
        for s in spell:
            if d.count(s) != 1:
                sub_flag = False
        if sub_flag:
            flag = True
    return 1 if flag else 2