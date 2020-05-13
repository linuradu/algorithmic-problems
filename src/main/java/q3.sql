
DROP TABLE IF EXISTS sometbl;
CREATE TABLE sometbl ( id INT, name VARCHAR(50) );
INSERT INTO sometbl VALUES (1, 'Smith'), (2, 'Julio|Jones|Falcons'), (3, 'White|Snow'), (4, 'Paint|It|Red'), (5, 'Green|Lantern'), (6, 'Brown|bag');

DROP PROCEDURE IF EXISTS split_columns;

DELIMITER $$

-- Splits column value and add each split element as new a new record to the table.
CREATE PROCEDURE split_columns()

BEGIN

  DECLARE delimeter VARCHAR(255);
	DECLARE id INT DEFAULT 0;
  DECLARE name VARCHAR(250);
  DECLARE occur INT DEFAULT 0;
	DECLARE i INT DEFAULT 0;
  DECLARE pipe INT DEFAULT 0;
  DECLARE splitted_name VARCHAR(50);
  DECLARE done INT DEFAULT 0;
	DECLARE sourceTable CURSOR FOR SELECT sometbl.id, sometbl.name FROM sometbl WHERE sometbl.name != '';
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

  SET delimeter = '|';

    -- table with the records for the split columns.
    DROP TABLE IF EXISTS temp_table;
    CREATE TABLE temp_table(id INT, name VARCHAR(250));

    OPEN sourceTable;

      read_loop: LOOP -- Read all the records from sometbl and split columns with pipes.

        FETCH sourceTable INTO id, name;

        IF done THEN
          LEAVE read_loop;
        END IF;

        SET pipe = LOCATE(delimeter, name);

        IF pipe > 0 THEN -- If the name contains pipe character '|' then split and add as a new record.

          SET occur = (SELECT LENGTH(name) - LENGTH(REPLACE(name, delimeter, '')) + 1 );
          SET i = 1;

          WHILE i <= occur DO

            SET splitted_name = (SELECT REPLACE(SUBSTRING(SUBSTRING_INDEX(name, delimeter, i), LENGTH(SUBSTRING_INDEX(name, delimeter, i - 1)) + 1), delimeter, ''));
            INSERT INTO temp_table(id, name) VALUES (id, splitted_name);
            SET i = i + 1;

          END WHILE;

        ELSE -- in case the name has no pipe so add it directly to the new table.
          INSERT INTO temp_table VALUES (id, name);
		    END IF;

      END LOOP;

      SELECT * FROM temp_table;
	CLOSE sourceTable;
END;
$$

DELIMITER ;

CALL split_columns();
