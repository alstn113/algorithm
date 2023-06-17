def compress_str(s, l):
    cnt = 1
    data = [s[:l]]
    for i in range(l, len(s), l):
        v = s[i:i+l]
        if data[-1] == v:
            cnt += 1
        else:
            if cnt > 1:
                data.append(str(cnt))
                cnt = 1
            data.append(v)
    if cnt > 1:
        data.append(str(cnt))
    
    compressed_str = "".join(data)
    return len(compressed_str)
        

def solution(s):
    str_len = len(s)
    answer = str_len
    for i in range(1, str_len//2+1):
        compressed_str = compress_str(s, i)
        answer = min(answer, compressed_str)
        
    return answer