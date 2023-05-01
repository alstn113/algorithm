def solution(arr1, arr2):
    # 조건 1
    if len(arr1) > len(arr2):
        return 1
    elif len(arr1) < len(arr2):
        return -1
    
    # 조건 2
    if sum(arr1) > sum(arr2):
        return 1
    elif sum(arr1) < sum(arr2):
        return -1
    else:
        return 0
