select 
    floor(price/10000)*10000 as price_group,
    count(*) as products
from product
group by price_group
order by price_group asc
