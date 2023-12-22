select product_code, sum(o.sales_amount)*p.price as sales
from offline_sale o
inner join product p -- inner join = join
on o.product_id = p.product_id
group by product_code
order by sales desc, product_code asc