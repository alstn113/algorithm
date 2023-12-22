select product_code, sum(p.price * o.sales_amount) as "SALES"
from offline_sale o
join product p
on o.product_id = p.product_id
group by product_code
order by sales desc, product_code asc