import sys
import math
input = sys.stdin.readline


def solution(progresses, speeds):
    answer = []
    delay_list = [math.ceil((100-progresses[i])/speeds[i])
                  for i in range(len(progresses))]
    cnt = 1
    tmp = delay_list[0]
    for i in range(1, len(delay_list)):
        if tmp >= delay_list[i]:
            cnt += 1
        else:
            answer.append(cnt)
            tmp = delay_list[i]
            cnt = 1
    answer.append(cnt)

    return answer