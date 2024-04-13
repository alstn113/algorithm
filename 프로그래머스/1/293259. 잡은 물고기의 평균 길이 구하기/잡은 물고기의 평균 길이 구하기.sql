select round(avg(ifnull(length, 10)), 2) as average_length
from fish_info