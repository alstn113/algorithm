def solution(str1, str2):
    answer = ""
    for i in range(len(str1)):
        answer += str1[i]
        answer += str2[i]
    return answer