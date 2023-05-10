n = int(input())


def hanoi(n, start, end, mid):
    if n == 1:
        print(start, end, sep=' ')
    else:
        hanoi(n-1, start, mid, end)
        print(start, end)
        hanoi(n-1, mid, end, start)


print(2**n-1)
if n <= 20:
    hanoi(n, 1, 3, 2)
