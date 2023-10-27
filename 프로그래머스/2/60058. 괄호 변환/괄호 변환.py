import sys
input = sys.stdin.readline


def check(p):
    if p == "":
        return p
    left = 0
    right = 0
    is_correct = True
    for i in range(len(p)):
        if p[i] == "(":
            left += 1
        else:
            right += 1
        if left < right:
            is_correct = False
        if left == right:
            break
    u = p[:i+1]
    v = p[i+1:]

    if is_correct:
        return u + check(v)
    else:
        return "(" + check(v) + ")" + flip(u[1:-1])


def flip(s):
    return_value = ""
    for v in s:
        if v == "(":
            return_value += ")"
        else:
            return_value += "("
    return return_value


def solution(p):
    return check(p)


if __name__ == "__main__":
    print(solution("(()())()"))
    print(solution(")("))
    print(solution("()))((()"))
