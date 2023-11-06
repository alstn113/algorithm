def solution(gems):
    """
    투 포인터
    """
    gems_type_count = len(set(gems))
    gems_dic = {}
    end_index = 0
    answer = [0, len(gems)]

    for start_index in range(len(gems)):
        # 조건을 만족할 때까지 end_index를 오른쪽으로 옮긴다.
        while len(gems_dic) < gems_type_count and end_index < len(gems):
            cur_gem_type = gems[end_index]
            gems_dic[cur_gem_type] = gems_dic.get(cur_gem_type, 0) + 1
            end_index += 1
        if len(gems_dic) == gems_type_count:
            if answer[1] - answer[0] > end_index - start_index:
                answer = [start_index, end_index]

            cur_gem_type = gems[start_index]
            gems_dic[cur_gem_type] -= 1
            if gems_dic[cur_gem_type] == 0:
                del gems_dic[cur_gem_type]

    answer[0] += 1
    return answer