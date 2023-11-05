def solution(id_list, reports, k):
    dic = {}
    # [내가 신고한 사람], [나를 신고한 사람]

    for id in id_list:
        dic[id] = [[], []]

    for report in reports:
        report_from, report_to = report.split()
        if report_from in dic:
            if report_to not in dic[report_from][0]:
                dic[report_from][0].append(report_to)

        if report_to in dic:
            if report_from not in dic[report_to][1]:
                dic[report_to][1].append(report_from)
    answer = []
    for id in id_list:
        cnt = 0
        report_list = dic[id][0]
        for r in report_list:
            if len(dic[r][1]) >= k:
                cnt += 1
        answer.append(cnt)

    return answer
