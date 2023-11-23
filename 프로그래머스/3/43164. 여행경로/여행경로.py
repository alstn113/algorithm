def solution(tickets):
    answer = []
    visited = [False]*len(tickets)

    def dfs(current, path):
        nonlocal answer

        if len(path) == len(tickets)+1:
            if not answer or path < answer:
                answer = path[:]
            return

        for idx, ticket in enumerate(tickets):
            if visited[idx]:
                continue

            a, b = ticket
            if current == a:
                visited[idx] = True
                tmp = path[:]
                tmp.append(b)
                dfs(b, tmp)
                visited[idx] = False

                # 백트래킹: 현재 경로가 이미 찾은 경로 중에서 사전 순으로 뒤에 있다면 종료
                if answer and path >= answer:
                    return

    dfs("ICN", ["ICN"])

    return answer