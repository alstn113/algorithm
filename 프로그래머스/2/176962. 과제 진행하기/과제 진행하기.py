def solution(plans):
    # 시작 시간을 분으로 변경하고 오름차순으로 정렬
    for i in range(len(plans)):
        hour, minute = plans[i][1].split(":")
        plans[i][1] = int(hour) * 60 + int(minute)
        plans[i][2] = int(plans[i][2])
    plans.sort(key=lambda x: x[1])

    stack = []
    result = []
    for i in range(len(plans)-1):
        cur, next = plans[i], plans[i+1]
        remaining_time = next[1] - cur[1]
        if remaining_time < cur[2]:
            cur[2] -= remaining_time
            stack.append(cur)
        else:
            result.append(cur[0])
            remaining_time -= cur[2]

            while stack:
                if stack[-1][2] > remaining_time:
                    stack[-1][2] -= remaining_time
                    break
                else:
                    remaining_time -= stack[-1][2]
                    v = stack.pop()
                    result.append(v[0])
    result.append(plans[-1][0])

    if stack:
        stack = [v[0] for v in stack]
        stack = stack[::-1]
        result += stack

    return result