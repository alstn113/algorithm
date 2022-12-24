from collections import deque


def isPalindrome(str):
    s = []
    q = deque()
    for c in str:
        s.append(c)
        q.append(c)
    while (not len(q) == 0 and s.pop() == q.popleft()):
        continue
    return len(q) == 0


print(isPalindrome("Check"))
print(isPalindrome("tgt"))
print(isPalindrome("ghgg"))
