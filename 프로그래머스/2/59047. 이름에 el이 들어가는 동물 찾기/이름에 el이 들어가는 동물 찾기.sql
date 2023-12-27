SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE  
    ANIMAL_TYPE = "Dog" AND
    UPPER(NAME) LIKE "%EL%"
ORDER BY NAME ASC