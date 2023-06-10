def solution(files):
    tmp = []
    for file in files:
        head = ""
        number = ""
        i = 0
        while file[i].isalpha() or file[i] in " .-":
            head += file[i]
            i += 1
        while i < len(file) and file[i].isdigit():
            number += file[i]
            i += 1
            if len(number) == 5:
                break
        tmp.append([file, head, number])
    print(tmp)
    tmp.sort(key=lambda x: (x[1].lower(), int(x[2])))
    
    result = [ v[0] for v in tmp ]
                
    return result
