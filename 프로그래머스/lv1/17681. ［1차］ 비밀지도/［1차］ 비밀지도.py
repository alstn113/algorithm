def solution(n, arr1, arr2):
    result = []
    for a, b in zip(arr1, arr2):
        result.append(bin(a | b)[2:].zfill(n).replace("1", "#").replace("0", " "))
        
    return result