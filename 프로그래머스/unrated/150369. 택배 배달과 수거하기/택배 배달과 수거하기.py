def solution(cap, n, deliveries, pickups):
    answer = 0

    parsed_deliveries = [[idx+1, value]
                         for idx, value in enumerate(deliveries) if value != 0]
    parsed_pickups = [[idx+1, value]
                      for idx, value in enumerate(pickups) if value != 0]

    while True:

        if not parsed_deliveries and not parsed_pickups:
            return answer

        fd = parsed_deliveries[-1][0] if parsed_deliveries else 0
        fp = parsed_pickups[-1][0] if parsed_pickups else 0
        answer += max(fd, fp)*2

        k = cap
        for i in range(len(parsed_deliveries)-1, -1, -1):
            v = parsed_deliveries[i][1] - k
            if v == 0:
                parsed_deliveries.pop()
                break
            elif v > 0:
                parsed_deliveries[i][1] = v
                break
            else:
                k -= parsed_deliveries[i][1]
                parsed_deliveries.pop()

        k = cap
        for i in range(len(parsed_pickups)-1, -1, -1):
            v = parsed_pickups[i][1] - k
            if v == 0:
                parsed_pickups.pop()
                break
            elif v > 0:
                parsed_pickups[i][1] = v
                break
            else:
                k -= parsed_pickups[i][1]
                parsed_pickups.pop()