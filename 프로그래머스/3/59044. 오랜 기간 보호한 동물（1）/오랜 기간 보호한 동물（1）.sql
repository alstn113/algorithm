select 
    ai.name,
    ai.datetime
from animal_ins as ai
left join animal_outs as ao
on ao.animal_id = ai.animal_id
where ao.animal_id is null
order by ai.datetime asc
limit 3