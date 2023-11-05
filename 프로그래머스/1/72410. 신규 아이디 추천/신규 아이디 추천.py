def solution(new_id):
    new_id = new_id.lower()
    new_id = list(new_id)

    for i in range(len(new_id)):
        if new_id[i].isalnum() or new_id[i] in "-_.":
            continue
        else:
            new_id[i] = ''

    new_id = ''.join(new_id)

    while ".." in new_id:
        new_id = new_id.replace("..", ".")

    if new_id and new_id[0] == ".":
        new_id = new_id[1:]

    if new_id and new_id[-1] == ".":
        new_id = new_id[:-1]

    if new_id == "":
        new_id = "a"

    if len(new_id) >= 16:
        new_id = new_id[:15]
        if new_id[-1] == ".":
            new_id = new_id[:-1]

    if len(new_id) <= 2:
        while len(new_id) < 3:
            new_id += new_id[-1]

    return new_id