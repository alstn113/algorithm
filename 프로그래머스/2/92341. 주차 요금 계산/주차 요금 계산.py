import sys
import math
input = sys.stdin.readline


def solution(fees, records):
    answer = []
    default_time, default_fee, unit_time, unit_fee = fees
    car_number_dic = {}
    for record in records:
        time, car_number, in_out = record.split(" ")
        if in_out == "IN":
            if car_number in car_number_dic:
                car_number_dic[car_number][0] = time
            else:
                car_number_dic[car_number] = [time, 0]
        else:
            in_time = car_number_dic[car_number][0]
            period = parse_to_minutes(time) - parse_to_minutes(in_time)
            car_number_dic[car_number][0] = -1
            car_number_dic[car_number][1] += period

    for k in car_number_dic.keys():
        if car_number_dic[k][0] != -1:
            period = parse_to_minutes(
                "23:59") - parse_to_minutes(car_number_dic[k][0])
            car_number_dic[k][1] += period
        t = car_number_dic[k][1]
        if default_time > t:
            answer.append([k, default_fee])
        else:
            fee = default_fee + math.ceil((t-default_time)/unit_time)*unit_fee
            answer.append([k, fee])

    answer.sort(key=lambda x: int(x[0]))
    return [x[1] for x in answer]


def parse_to_minutes(time):
    a, b = time.split(":")
    return int(a)*60 + int(b)


