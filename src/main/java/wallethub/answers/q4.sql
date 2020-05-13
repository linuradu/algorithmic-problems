DROP TABLE IF EXISTS bugs;
CREATE TABLE bugs (id INT, severity INT, open_date DATE, close_date DATE);

INSERT INTO bugs VALUES(1, 1, STR_TO_DATE('2015-11-29', '%Y-%m-%d'), STR_TO_DATE('2015-11-30', '%Y-%m-%d'));
INSERT INTO bugs VALUES(2, 1, STR_TO_DATE('2017-11-10', '%Y-%m-%d'), STR_TO_DATE('2017-11-11', '%Y-%m-%d'));
INSERT INTO bugs VALUES(3, 1, STR_TO_DATE('2017-11-13', '%Y-%m-%d'), STR_TO_DATE('2017-11-13', '%Y-%m-%d'));
INSERT INTO bugs VALUES(4, 1, STR_TO_DATE('2017-11-14', '%Y-%m-%d'), STR_TO_DATE('2017-11-15', '%Y-%m-%d'));
INSERT INTO bugs VALUES(5, 1, STR_TO_DATE('2017-11-15', '%Y-%m-%d'), STR_TO_DATE('2017-11-16', '%Y-%m-%d'));
INSERT INTO bugs VALUES(5, 1, STR_TO_DATE('2017-11-16', '%Y-%m-%d'), STR_TO_DATE('2017-11-16', '%Y-%m-%d'));

DROP PROCEDURE IF EXISTS show_open_bugs;
DELIMITER $$

CREATE PROCEDURE show_open_bugs(fromDate DATE, toDate DATE)
BEGIN

  DECLARE number_of_bugs INT DEFAULT 0;
  DROP TABLE IF EXISTS temp_table;
  CREATE TABLE temp_table(datum DATE, open_bugs INT);

	WHILE fromDate <= toDate DO
       SET number_of_bugs = (SELECT COUNT(id) FROM bugs WHERE close_date IS NOT NULL AND DATE(open_date) <= fromDate AND DATE(close_date) > fromDate);

       INSERT INTO temp_table VALUES (fromDate, number_of_bugs);
       SET fromDate = ADDDATE(fromDate, INTERVAL 1 DAY);
	END WHILE;
    SELECT  DATE_FORMAT(datum,'%Y-%m-%d') as 'date', open_bugs as 'Open bugs'  FROM temp_table;
END;
$$

DELIMITER ;

CALL show_open_bugs(STR_TO_DATE('2017-11-03', '%Y-%m-%d'), STR_TO_DATE('2017-11-16', '%Y-%m-%d'));
