def check(a, b):
    diff = 0
    for i, j in zip(a, b):
        if i != j:
            diff += 1
    if diff == 1:
        return True
    return False

def dfs(p, target, words, visited):
    global answer
    
    if p == target:
        answer = min(answer, sum(visited))    
        return
    
    for idx, word in enumerate(words):
        if visited[idx]:
            continue
        if not check(p, word):
            continue
        visited[idx] = True
        dfs(word, target, words, visited)
        visited[idx] = False

def solution(begin, target, words):
    visited  = [False]*len(words)
    global answer 
    answer = 1e9
    
    dfs(begin, target, words, visited)
    
    if answer == 1e9:
        return 0
    else:
        return answer