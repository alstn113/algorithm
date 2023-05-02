def solution(my_string):
    s = ''.join(i if i.isdigit() else ' ' for i in my_string)
    return sum(int(i) for i in s.split())

# 기존 풀이
#
# def solution(my_string):
#     answer = 0
#     tmp = ""
#     for i in my_string:
#         if i.isnumeric():
#             tmp += i
#         elif tmp != "":
#             answer += int(tmp)
#             tmp = ""
#     if tmp != "":
#         answer += int(tmp)
    
#     return answer
    
            