select round(avg(daily_fee)) as average_fee
from car_rental_company_car
where car_type = "SUV"