select ii.item_id, ii.item_name
from item_info as ii
join item_tree as it
on ii.item_id = it.item_id
where it.parent_item_id is null