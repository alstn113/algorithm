def solution(age):
    answer = ""
    data = "abcdefghijklmnopqrstuvwxyz"
    for i in str(age):
        answer += data[int(i)]
    return answer