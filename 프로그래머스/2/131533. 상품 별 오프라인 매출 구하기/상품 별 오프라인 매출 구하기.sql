select 
    product_code, 
    sum(os.sales_amount) * p.price as sales
from offline_sale as os
join product as p
on os.product_id = p.product_id
group by product_code
order by sales desc, product_code asc
