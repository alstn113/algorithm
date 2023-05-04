def solution(chicken):
    total_service = 0
    while chicken >= 10:
        order = chicken // 10
        coupen = chicken % 10
        total_service += order
        chicken = order+coupen
    return total_service