# 실패율 = 도달했으나 클리어 x / 스테이지 도달한 플레이어 수

# 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 리턴


def solution(N, stages):
    data = [0]*(N+2)
    result = []
    l = len(stages)
    for stage in stages:
        data[stage] += 1
    k = 0
    for i in range(1, N+1):
        if l-k == 0:        
            result.append([0, i])
        else:
            result.append([data[i]/(l-k) ,i])
        k += data[i]
    result.sort(key=lambda x: -x[0])
    result = [x[1] for x in result]    
    return result