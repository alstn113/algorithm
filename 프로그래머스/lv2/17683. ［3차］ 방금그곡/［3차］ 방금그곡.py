def solve_sharp(m):
    sharp = [("C#", "c"), ("D#", "d"), ("F#", "f"), ("G#", "g"), ("A#", "a")]
    for s in sharp:
        m = m.replace(s[0], s[1])
    return m

def parse_time(s, e):
    s = int(s.split(":")[0])*60 + int(s.split(":")[1])
    e = int(e.split(":")[0])*60 + int(e.split(":")[1])
    time = e-s
    return time

def make_full_music(music, time):
    return music*(time//len(music)) + music[:time%len(music)]

def solution(m, musicinfos):
    m = solve_sharp(m)
    
    result = []
    for idx, info in enumerate(musicinfos):
        s, e, title, music = info.split(",")
        time = parse_time(s, e)
        music = solve_sharp(music)
        full_music = make_full_music(music, time)
        
        if m in full_music:
            result.append([title, time, idx])
            
    result.sort(key=lambda x: (-x[1], x[2]))
    
    if result:
        return result[0][0]
    return "(None)"