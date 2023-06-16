from itertools import product

def buy(user, emoticons, discounts):
    discount_limit, plus_service_limit = user
    
    price = 0
    
    for emoticon, discount in zip(emoticons, discounts):
        if discount < discount_limit:
            continue
        price += emoticon - int(emoticon*0.01*discount)
    
    if plus_service_limit <= price:
        return [True, 0]
    else:
        return [False, price]

def solution(users, emoticons):
    result = [0,0]
    
    for discounts in product([10,20,30,40], repeat=len(emoticons)):
        total_plus_service_user = 0
        total_price = 0
        
        for user in users:
            join_service, price = buy(user, emoticons, discounts)
            if join_service:
                total_plus_service_user += 1
            else:
                total_price += price

        if result[0] < total_plus_service_user:
            result = [total_plus_service_user, total_price]
        elif result[0] == total_plus_service_user and result[1] < total_price:
            result = [total_plus_service_user, total_price]
        
    return result