def parse_time(time):
    hour, minute = time.split(":")
    return int(hour)*60 + int(minute)


def get_playtime(start_time, end_time):
    return parse_time(end_time) - parse_time(start_time)


def parse_music(music):
    music = music.replace("C#", "c")
    music = music.replace("D#", "d")
    music = music.replace("F#", "f")
    music = music.replace("G#", "g")
    music = music.replace("A#", "a")
    return music


def extend_music(akbo, playtime):
    a, b = divmod(playtime, len(akbo))
    return a * akbo + akbo[:b]


def solution(melody, musicinfos):
    answer = []
    for music in musicinfos:
        melody = parse_music(melody)
        start_time, end_time, music_name, akbo = music.split(",")
        playtime = get_playtime(start_time, end_time)
        akbo = parse_music(akbo)
        akbo = extend_music(akbo, playtime)

        print(melody)
        print(akbo)

        if melody in akbo:
            answer.append([music_name, playtime])

    answer.sort(key=lambda x: -x[1])
    if answer:
        return answer[0][0]
    return "(None)"
