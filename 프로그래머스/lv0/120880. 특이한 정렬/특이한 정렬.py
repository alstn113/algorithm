def solution(numlist, n):
    numlist.sort(reverse=True)
    numlist.sort(key = lambda x: abs(x-n))
    return numlist