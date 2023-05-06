def solution(s, skip, index):
    data = "abcdefghijklmnopqrstuvwxyz"
    check = [True]*26

    for q in skip:
        check[ord(q)-97] = False

    result = ""

    for i in range(len(s)):
        t = ord(s[i])-97
        v = 0
        while True:
            if v == index:
                print(data[t % 26])
                result += data[t % 26]
                break
            t += 1
            if not check[t % 26]:
                continue
            v += 1

    return result