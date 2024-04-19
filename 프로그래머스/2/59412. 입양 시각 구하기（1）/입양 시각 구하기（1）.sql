select 
    hour(datetime) as hour,
    count(*)
from animal_outs
group by hour
having hour >= 9 and hour <= 19
order by hour asc