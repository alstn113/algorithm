def solution(numbers):
    numbers.sort(reverse=True)
    return numbers[0]*numbers[1]