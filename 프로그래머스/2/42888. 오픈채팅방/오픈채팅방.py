def solution(records):
    dic = {}
    answer = []
    for record in records:
        # command = Enter, Leave, Change
        if record.startswith("Leave"):
            command, uid = record.split()
        else:
            command, uid, name = record.split()
        if command == "Enter" or command == "Change":
            dic[uid] = name
        answer.append([command, uid])

    result = []
    for message in answer:
        command, uid = message
        if command == "Enter":
            result.append(f"{dic[uid]}님이 들어왔습니다.")
        elif command == "Leave":
            result.append(f"{dic[uid]}님이 나갔습니다.")

    return result