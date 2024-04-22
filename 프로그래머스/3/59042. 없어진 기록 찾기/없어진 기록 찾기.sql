select
    ao.animal_id,
    ao.name
from animal_outs as ao
left join animal_ins as ai
on ai.animal_id = ao.animal_id
where ai.animal_id is null