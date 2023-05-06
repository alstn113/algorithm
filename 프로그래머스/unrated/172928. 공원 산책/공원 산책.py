def find_start_location(park):
    for i in range(len(park)):
        for j in range(len(park[0])):
            if park[i][j] == "S":
                return [i, j]


def solution(park, routes):
    x, y = find_start_location(park)
    direction = {"E": [0, 1], "W": [0, -1], "N": [-1, 0], "S": [1, 0]}
    for r in routes:
        d, c = r.split(" ")
        t_x, t_y = x, y

        flag = True
        for _ in range(int(c)):
            nx = x + direction[d][0]
            ny = y + direction[d][1]
            if not (0 <= nx < len(park) and 0 <= ny < len(park[0])):
                flag = False
                break
            if park[nx][ny] == "X":
                flag = False
                break
            x = nx
            y = ny
        if not flag:
            x = t_x
            y = t_y

    return x, y
