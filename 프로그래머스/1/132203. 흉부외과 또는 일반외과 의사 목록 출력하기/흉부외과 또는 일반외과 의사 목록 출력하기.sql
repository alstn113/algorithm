select dr_name, dr_id, mcdp_cd, date_format(hire_YMD, "%Y-%m-%d")
from doctor
where mcdp_cd = "CS" OR mcdp_cd = "GS"
order by hire_ymd desc, dr_name asc