def solution(players, callings):
    
    dic = {}
    for idx, value in enumerate(players):
        dic[value] = idx

    for c in callings:
        pre , idx = dic[c] - 1 , dic[c]
        players[pre], players[idx] = players[idx] , players[pre]
        dic[players[pre]] , dic[players[idx]] = dic[players[pre]] - 1 , dic[players[idx]] + 1

    return players