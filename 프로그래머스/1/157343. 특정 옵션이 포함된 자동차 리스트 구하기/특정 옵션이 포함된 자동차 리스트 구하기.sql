select car_id, car_type, daily_fee, options
from car_rental_company_car
where options like "%네비게이션%"
order by car_id desc