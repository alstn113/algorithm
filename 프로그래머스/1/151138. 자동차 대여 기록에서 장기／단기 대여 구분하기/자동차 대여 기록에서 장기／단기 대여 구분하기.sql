select 
  history_id,
  car_id,
  date_format(start_date, "%Y-%m-%d") as start_date,
  date_format(end_date, "%Y-%m-%d") as end_date,
  case
    when datediff(end_date, start_date) < 29 then "단기 대여"
    else "장기 대여"
  end as rent_type
from car_rental_company_rental_history
where start_date like "2022-09-%"
order by history_id desc
 