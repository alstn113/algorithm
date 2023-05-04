def solution(numbers, k):
    return numbers[k*2%len(numbers)-2]