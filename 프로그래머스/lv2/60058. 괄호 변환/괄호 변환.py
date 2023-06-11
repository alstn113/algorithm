def split_to_balanced_str(p):
    left = 0
    right = 0
    for idx, value in enumerate(p):
        if value == "(":
            left += 1
        else:
            right += 1
        if left == right and left > 0:
            return p[:idx+1], p[idx+1:]
        
def check_correct_str(p):
    left = 0
    right = 0
    
    for idx, value in enumerate(p):
        if value == "(":
            left += 1
        else:
            right += 1
        if left < right: 
            return False
    if left == right:
        return True
    else:
        return False

def check(p):
    if p == "":
        return "" 
    u, v = split_to_balanced_str(p)
    
    if check_correct_str(u):
        return u + check(v)
    else:
        edited_u = ""
        for i in range(1, len(u)-1):
            if u[i] == "(":
                edited_u += ")"
            else:
                edited_u += "("
        
        return "(" + check(v) + ")" + edited_u
    
def solution(p):
    return check(p)
    

        
        
        
        

    

            
            
            