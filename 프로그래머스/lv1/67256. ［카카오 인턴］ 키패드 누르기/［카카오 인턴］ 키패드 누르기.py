def solution(numbers, hand):
    keypad = {
        1: [0,0],
        2: [0,1],
        3: [0,2],
        4: [1,0],
        5: [1,1],
        6: [1,2],
        7: [2,0],
        8: [2,1],
        9: [2,2],
        0: [3,1]
    }
    left = [3,0]
    right = [3,2]
    
    result = ''
    for num in numbers:
        a, b = keypad[num]
        if num in [1,4,7]:
            result += "L"
            left = [a,b]
            continue
        elif num in [3,6,9]:
            result += "R"
            right = [a,b]
            continue
        
        l = abs(left[0] - a) + abs(left[1] - b)
        r = abs(right[0] - a) + abs(right[1] - b)
        print(l, r)
        if l < r: 
            result += "L"
            left = [a,b]
        elif r < l:
            result += "R"
            right = [a,b]
        elif r == l:
            if hand == "right":
                result += "R"
                right = [a,b]
            else:
                result += "L"
                left = [a,b]
        
        
    return result