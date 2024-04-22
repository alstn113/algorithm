with fe as (
    select * from skillcodes where category = "Front End"
)

select 
    distinct id,
    email,
    first_name,
    last_name
from (
    developers as dev
    join fe
    on dev.skill_code & fe.code
)
order by id
