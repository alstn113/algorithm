def solution(my_string, letter):
    return my_string.replace(letter, "")

# 기존 풀이 
# 
# def solution(my_string, letter):
#     answer = ""
#     for i in my_string:
#         if i != letter:
#             answer += i
#     return answer
