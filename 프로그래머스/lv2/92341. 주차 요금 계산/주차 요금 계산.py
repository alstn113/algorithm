import math

def solution(fees, records):
    parking_lot = {}
    LAST_OUT = 23*60+59
    for record in records:
        time, car_number, inout = record.split(" ")
        hour, minute = list(map(int, time.split(":")))
        
        time = hour*60 + minute
        
        if car_number not in parking_lot:
            parking_lot[car_number] = [time, 0, "IN"]
        else:
            if inout == "IN":
                parking_lot[car_number][0] = time
                parking_lot[car_number][2] = "IN"
            else:
                diff = time - parking_lot[car_number][0]
                parking_lot[car_number][1] += diff
                parking_lot[car_number][2] = "OUT"

    answer = []
    
    for key, value in parking_lot.items():
        time = value[1]
        if value[2] == "IN":
            time += LAST_OUT - value[0]
        fee = fees[1]
        if fees[0] < time:
            fee += math.ceil((time-fees[0])/fees[2])*fees[3]
        answer.append([key, fee])
    answer.sort(key=lambda x: x[0])
    answer = [ v[1] for v in answer ]
    return answer