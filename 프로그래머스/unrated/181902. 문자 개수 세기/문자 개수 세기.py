def solution(my_string):
    answer = [0]*52
    for i in my_string:
        if i.isupper():
            answer[ord(i)-65] += 1
        else:
            answer[26+ord(i)-97] += 1
            
        
    
    return answer