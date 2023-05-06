def solution(s):
    dic = {}
    answer = []
    for i in range(len(s)):
        if s[i] not in dic:
            dic[s[i]] = i
            answer.append(-1)
        else:
            v = i - dic[s[i]]
            answer.append(v)
            dic[s[i]] = i
            
    return answer