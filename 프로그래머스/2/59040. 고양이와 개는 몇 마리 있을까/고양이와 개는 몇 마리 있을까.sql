select 
    animal_type, 
    count(animal_type) as "count"
from animal_ins
group by animal_type
order by animal_type asc