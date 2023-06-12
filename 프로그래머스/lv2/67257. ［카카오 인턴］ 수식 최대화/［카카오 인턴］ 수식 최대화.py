from itertools import permutations


def evaluate(expression, case, n):
    expression = expression.split(case[n])

    v = 0
    if n == 2:
        v = int(expression[0])
    else:
        v = int(evaluate(expression[0], case, n+1))

    for i in range(1, len(expression)):
        if n == 2:
            if case[n] == "*":
                v *= int(expression[i])
            elif case[n] == "+":
                v += int(expression[i])
            else:
                v -= int(expression[i])
        else:
            if case[n] == "*":
                v *= int(evaluate(expression[i], case, n+1))
            elif case[n] == "+":
                v += int(evaluate(expression[i], case, n+1))
            else:
                v -= int(evaluate(expression[i], case, n+1))
    return v


def solution(expression):
    cases = list(permutations(['*', "+", "-"], 3))

    maxAnswer = 0
    for case in cases:
        v = evaluate(expression, case, 0)
        print(abs(v))
        maxAnswer = max(maxAnswer, abs(v))

    return maxAnswer


