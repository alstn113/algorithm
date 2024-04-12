select
    b.title,
    b.board_id,
    r.reply_id,
    r.writer_id,
    r.contents,
    date_format(r.created_date, "%Y-%m-%d") as created_date
from used_goods_board as b
join used_goods_reply as r
on b.board_id = r.board_id
where b.created_date like "%2022-10%"
order by created_date asc, title asc 