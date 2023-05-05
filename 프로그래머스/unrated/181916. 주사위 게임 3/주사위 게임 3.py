def solution(a, b, c, d):
    dice = {}
    data = [a,b,c,d]
    for i in data:
        if i not in dice:
            dice[i] = 1
        else:
            dice[i] += 1
    
    l = len(dice)
    if l == 1:
        return 1111*a
    elif l == 4:
        return min(data)
    elif l == 3:
        answer = 1
        for key, value in dice.items():
            if value == 1:
                answer *= key
        return answer
    else:
        # 3/1 or 2/2
        three = 0
        one = 0
        two = []
        for key, value in dice.items():
            if value == 3:
                three = key
            elif value == 1:
                one = key
            else:
                two.append(key)
        if three:
            return (10*three+one)**2
        else:
            return (two[0]+two[1])*abs(two[0]-two[1])
