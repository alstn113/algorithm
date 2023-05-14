def solution(numbers):
    result = []
    stack = []
    for i in range(len(numbers)-1, -1, -1):
        if not stack:
            result.append(-1)
            stack.append(numbers[i])
        elif stack[-1] <= numbers[i]:
            while True:
                if not stack:
                    result.append(-1)
                    stack.append(numbers[i])
                    break
                if stack[-1] <= numbers[i]:
                    stack.pop()
                elif stack[-1] > numbers[i]:
                    result.append(stack[-1])
                    stack.append(numbers[i])
                    break
        elif stack[-1] > numbers[i]:
            result.append(stack[-1])
            stack.append(numbers[i])

    return result[::-1]