 SELECT @rank := @rank + 1 as rank, name, votes
 FROM votes v, (SELECT @rank := 0 ) r
 order by votes desc;
