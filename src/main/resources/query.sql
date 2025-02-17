select product_name
from netology.orders ord
join netology.customers cust on ord.customer_id = cust.id
where lower(cust.name) = lower(:name);