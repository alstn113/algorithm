select fh.flavor
from first_half as fh
join icecream_info as ii
on fh.flavor = ii.flavor
where total_order > 3000 and ingredient_type = "fruit_based"