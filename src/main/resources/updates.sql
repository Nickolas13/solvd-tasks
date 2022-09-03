UPDATE `mydb`.`customer`
SET
`cs_id` = 4
WHERE `id` = 3;

UPDATE `mydb`.`customer`
SET
`lastname` = "depp"
WHERE `id` = 6;

UPDATE `mydb`.`customer`
SET
`firstname` = "nickolas"
WHERE `id` = 2;

UPDATE `mydb`.`company`
SET
`name` = "solvd",
`email` = "solvd@gmail.com"
WHERE `id` = 1;

UPDATE `mydb`.`factories`
SET
`pa_month` = "50000"
WHERE `id` = 3;


UPDATE `mydb`.`factories`
SET
`name` = "factory"
WHERE `id` = 1;

UPDATE `mydb`.`employees`
SET
`lastname` = "cruze"
WHERE `id` = 4;

UPDATE `mydb`.`employees`
SET
`email` = "student@gmail.com"
WHERE `id` = 2;

UPDATE `mydb`.`employees`
SET
`factories_id` = "3"
WHERE `id` = 3;

UPDATE `mydb`.`employees`
SET
`customer service_id` = "3"
WHERE `id` = 5;




