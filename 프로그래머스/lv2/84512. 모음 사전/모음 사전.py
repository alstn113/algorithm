def dfs(s, word, data):
    print(s)
    global answer
    answer += 1
    
    if s == word:
        return True
    if len(s) == 5:
        return False
    
    for a in data:
        if dfs(s+a, word, data):
            return True

def solution(word):
    global answer
    answer = 0
    
    alphabet = ['A', 'E', 'I', 'O', 'U']
    
    
    for a in alphabet:
        if dfs(a, word, alphabet):
            return answer
        