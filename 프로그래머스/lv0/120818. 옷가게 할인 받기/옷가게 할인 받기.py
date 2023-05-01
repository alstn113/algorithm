def solution(price):
    if price >= 500000:
        return int(price - price*0.2)
    if price >= 300000:
        return int(price - price*0.1)
    elif price >= 100000:
        return int(price - price*0.05)
    else:
        return price
 