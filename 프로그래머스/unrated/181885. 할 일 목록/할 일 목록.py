def solution(todo_list, finished):
    answer = []
    for idx, v in enumerate(todo_list):
        if not finished[idx]:
            answer.append(v)
            
    return answer
        
        