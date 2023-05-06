def solution(wallpaper):
    lux, luy, rdx, rdy = -1, 1e9, 0, 0
    for i in range(len(wallpaper)):
        if "."*len(wallpaper[0]) != wallpaper[i]:
            if lux == -1:
                lux = i
            rdx = i
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == "#":
                luy = min(luy, j)
                rdy = max(rdy, j)
    
    return [lux, luy, rdx+1, rdy+1]