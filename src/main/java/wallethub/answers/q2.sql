
DROP TABLE IF EXISTS words;
CREATE TABLE words (text VARCHAR(250));
INSERT INTO words (text) VALUES ("UNITED states Of AmERIca");
INSERT INTO words (text) VALUES ("rOmAnIa");
INSERT INTO words (text) VALUES ("tesTing String inside tHE method");

-- Capitalises the first letter of every word in a given string.
DROP FUNCTION IF EXISTS CAPITALIZE_WORD_FIRST_CHAR;

DELIMITER $$

CREATE FUNCTION CAPITALIZE_WORD_FIRST_CHAR(input VARCHAR(250))
  RETURNS VARCHAR(250)

BEGIN

  DECLARE output VARCHAR(250); 	-- the final processed and capitalised value.
  DECLARE processingIndex INT;  -- the Index of the character in the loop.
  DECLARE prevChar VARCHAR(1); 	-- the previous character in the loop.
  DECLARE curChar VARCHAR(1);  	-- the current character in the loop.

  -- initially the first char will be set as UPPERCASE
  SET output = UCASE(LEFT(input, 1));
  SET processingIndex = 1;
  SET prevChar = SUBSTRING(input, processingIndex, 1);
  SET curChar = "";

  elementLoop: LOOP
    -- for every loop increase
	SET processingIndex = processingIndex + 1;

    -- getting the characther form "input" string, starting at position "crt" having the length "1"
    SET curChar = SUBSTRING(input, processingIndex, 1);

    -- the idea of alghorithm is that after every space(" ") the first character will be uppercase and the other characters will be lowercase
    IF prevChar = " " THEN
      SET output = CONCAT(output, UCASE(curChar));
    ELSE
      SET output = CONCAT(output, LCASE(curChar));
    END IF;

    SET prevChar = curChar;

    IF (processingIndex < LENGTH(input)) THEN
      ITERATE elementLoop;
    END IF;

    LEAVE elementLoop;

  END LOOP elementLoop;

  RETURN output;
END;
$$
DELIMITER ;

SELECT CAPITALIZE_WORD_FIRST_CHAR(text) FROM words;








