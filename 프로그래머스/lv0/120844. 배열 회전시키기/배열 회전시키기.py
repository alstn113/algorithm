def solution(numbers, direction):
    a = numbers[-1]
    b = numbers[:len(numbers)-1]
    c = numbers[0]
    d = numbers[1:]
    return [a]+b if direction == "right" else d+[c]