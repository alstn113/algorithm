select 
    ao.animal_id,
    ao.name
from animal_outs as ao
join animal_ins as ai
on ao.animal_id = ai.animal_id
where ao.datetime < ai.datetime
order by ai.datetime asc