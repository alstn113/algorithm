select count(*) as "COUNT"
from ecoli_data
where (not genotype & 2) and (genotype & 1 or genotype & 4)