select 
    left(product_code, 2) as category,
    count(product_id) as products
from product
group by category
order by category asc