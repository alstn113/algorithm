def solution(id_pw, db):
    flag = True
    for d in db:
        a_id, a_pw = d
        if id_pw[0] == a_id:
            if id_pw[1] == a_pw:
                return "login"
            else:
                flag = False
    
    if flag:
        return "fail"
    else:
        return "wrong pw"
        
        