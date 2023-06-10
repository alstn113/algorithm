def solution(record):   
    dic = {}
    result = []
    for r in record:
        if r.startswith("Enter"):
            action, user_id, username = r.split(" ")
            dic[user_id] = username
            result.append([user_id, action])
        elif r.startswith("Change"):
            action, user_id, username = r.split(" ")
            dic[user_id] = username
        else:
            action, user_id = r.split(" ")
            result.append([user_id, action])
            
    for idx, value in enumerate(result):
        if value[1] == "Enter":
            result[idx] = f"{dic[value[0]]}님이 들어왔습니다."
        else:
            result[idx] = f"{dic[value[0]]}님이 나갔습니다."
        
    return result