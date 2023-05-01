from functools import reduce

def solution(num_list):
    a = reduce(lambda acc, cur: acc*cur, num_list)
    b = reduce(lambda acc, cur: acc+cur, num_list)**2
    return 1 if a < b else 0