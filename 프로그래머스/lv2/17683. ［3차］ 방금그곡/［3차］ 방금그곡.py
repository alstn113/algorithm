def solve_sharp(music):
    sharp = ["A#", "C#", "D#", "F#", "G#"]
    lower = ["a", "c", "d", "f", "g"]
    for a, b in zip(sharp, lower):
        music = music.replace(a, b)

    return music


def solution(m, musicinfos):
    answer = []
    for idx, info in enumerate(musicinfos):
        music = info.split(',')
        start = music[0].split(':')
        end = music[1].split(':')

        playtime = (int(end[0])*60 + int(end[1])) - \
            (int(start[0])*60 + int(start[1]))

        changed = solve_sharp(music[3])

        a = len(changed)

        b = changed * (playtime // a) + changed[:playtime % a]

        m = solve_sharp(m)

        if m in b:
            answer.append([playtime, idx, music[2]])

    answer = sorted(answer, key=lambda x: (-x[0], x[1]))

    return not answer and "(None)" or answer[0][2]
