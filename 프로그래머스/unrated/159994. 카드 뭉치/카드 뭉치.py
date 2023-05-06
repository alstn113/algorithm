def solution(cards1, cards2, goal):
    i = 0
    j = 0
    for k in range(len(goal)):
        if i < len(cards1) and cards1[i] == goal[k]:
            i += 1
            continue
        elif j < len(cards2) and cards2[j] == goal[k]:
            j += 1
            continue
        return "No"
    return "Yes"