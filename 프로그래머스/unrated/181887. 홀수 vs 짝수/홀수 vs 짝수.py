def solution(num_list):
    a = sum([ num_list[i] for i in range(0, len(num_list), 2)])
    b = sum([ num_list[i] for i in range(1, len(num_list), 2)])
    print(a, b)
    return a if a > b else b
        
