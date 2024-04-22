select fh.flavor
from first_half as fh
join july as j
on fh.flavor = j.flavor
group by fh.flavor
order by sum(fh.total_order) + sum(j.total_order) desc
limit 3
