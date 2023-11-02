def parse_file_name(file):
    i = 0
    head = ""
    number = ""
    while i < len(file):
        v: str = file[i]
        if v.isalpha():
            head += v.lower()
        elif v in " .-":
            head += v
        else:
            break
        i += 1
    while i < len(file):
        v = file[i]
        if v.isdigit():
            number += v
        else:
            break
        i += 1
    if i == len(file) - 1:
        tail = ""
    else:
        tail = file[i:]
    return file, head, int(number), tail


def solution(files):
    files = [parse_file_name(file) for file in files]
    files.sort(key=lambda x: (x[1], x[2]))
    return [file[0] for file in files]