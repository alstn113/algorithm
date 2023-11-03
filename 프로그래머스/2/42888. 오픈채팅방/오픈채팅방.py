def solution(records):
    dic = {}
    answer = []
    for record in records:
        # command = Enter, Leave, Change
        if record.startswith("Leave"):
            command, uid = record.split()
            answer.append([command, uid])
        elif record.startswith("Enter"):
            command, uid, name = record.split()
            dic[uid] = name
            answer.append([command, uid])
        else:
            command, uid, name = record.split()
            dic[uid] = name

    result = []
    for (command, uid) in answer:
        if command == "Enter":
            result.append(f"{dic[uid]}님이 들어왔습니다.")
        else:
            result.append(f"{dic[uid]}님이 나갔습니다.")

    return result
