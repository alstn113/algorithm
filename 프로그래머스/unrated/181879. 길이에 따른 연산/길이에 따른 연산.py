from functools import reduce 

def solution(num_list):
    return sum(num_list) if len(num_list) >= 11 else reduce(lambda x,y:x*y ,num_list)