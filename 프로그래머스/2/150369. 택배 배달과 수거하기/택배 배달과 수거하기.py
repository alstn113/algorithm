import sys
input = sys.stdin.readline


def solution(cap, n, deliveries, pickups):
    answer = 0

    while deliveries or pickups:

        while deliveries and deliveries[-1] == 0:
            deliveries.pop()
        while pickups and pickups[-1] == 0:
            pickups.pop()

        if len(deliveries) >= len(pickups):
            answer += len(deliveries)
        else:
            answer += len(pickups)

        temp_cap = cap
        while temp_cap > 0 and deliveries:
            if temp_cap >= deliveries[-1]:
                temp_cap -= deliveries[-1]
                deliveries.pop()
            else:
                deliveries[-1] -= temp_cap
                break

        temp_cap = cap
        while temp_cap > 0 and pickups:
            if temp_cap >= pickups[-1]:
                temp_cap -= pickups[-1]
                pickups.pop()
            else:
                pickups[-1] -= temp_cap
                break

    return answer * 2
