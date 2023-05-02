def solution(date1, date2):
    if date1[0] < date2[0]:
        return 1
    elif date1[0] > date2[0]:
        return 0
    if date1[1] < date2[1]:
        return 1
    elif date1[1] > date2[1]:
        return 0
    if date1[2] < date2[2]:
        return 1
    elif date1[2] > date2[2]:
        return 0
    return 0