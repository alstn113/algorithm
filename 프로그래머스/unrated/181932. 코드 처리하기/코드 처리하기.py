def solution(code):
    mode = 0
    ret = ""
    for idx, v in enumerate(code):
        if mode == 0:
            if code[idx] != "1":
                if idx%2 == 0:
                    ret += v
            else:        
                mode = 1
        elif mode == 1:
            if code[idx] != "1":
                if idx%2 != 0:
                    ret += v
            else:
                mode = 0
                    

    return ret if ret != "" else "EMPTY"