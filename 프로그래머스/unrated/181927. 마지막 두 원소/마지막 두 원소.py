def solution(num_list):
    if num_list[-1] > num_list[-2]:
        return num_list+[num_list[-1]-num_list[-2]]
    else:
        return num_list+[num_list[-1]*2]
