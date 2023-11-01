def parse_time(time):
    hour, minute = time.split(":")
    return int(hour)*60 + int(minute)


def get_playtime(start_time, end_time):
    return parse_time(end_time) - parse_time(start_time)


def parse_music(music: str):
    return music.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")


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

        if melody in akbo:
            answer.append([music_name, playtime])

    answer.sort(key=lambda x: -x[1])
    return answer[0][0] if answer else "(None)"
