


#adding companies
INSERT INTO `mydb`.`company`
(`id`,
`name`,
`location`,
`phone`,
`email`)
VALUES
(1,"companyname","mexico",794323645,"company@gmail.com"),
(2,"companyname","germany",54133657,"company@gmail.com");

#adding factories
INSERT INTO `mydb`.`factories`
(
`name`,
`prod_type`,
`pa_month`,
`company_id`)
VALUES
("thefactory","clothes",10000,1),
("bakingfactory","bread",20000,2),
("sweets","candy",50000,1),
("electronics","laptop",5000,1),
("building","stones",100000,2);


#adding  employees
INSERT INTO `mydb`.`employees`
(
`firstname`,
`lastname`,
`email`,
`company_id`,
`factories_id`,
`cs_id`)
VALUES
("steve","wick","steve@gmail.com",1,3,4),
("steve","wick","steve@gmail.com",1,1,3),
("steve","wick","steve@gmail.com",2,3,5),
("steve","wick","steve@gmail.com",1,5,1);


#inserting elements in customer service
INSERT INTO `mydb`.`customerservice`
(`location`,`work_from`,`work_till`)
VALUES
("smth street","monday","friday"),
("smth street","tuesday","friday"),
("smth street","monday","saturday"),
("smth street","monday","thursday"),
("smth street","monday","sunday"),
("smth street","wednesday","sunday"),
("smth street","monday","friday");


#inserting customers
INSERT INTO `mydb`.`customer`
(
`firstname`,
`lastname`,
`city`,
`phone`,
`email`,
`cs_id`)
VALUES
("alex","anderson","san francisco",785421,"alex@gmail.com",1),
("bob","smith","san francisco",621345,"bob@gmail.com",2),
("john","wick","new york",367984,"john@gmail.com",3),
("gigi","anderson","california",6874321,"alex@gmail.com",4),
("arina","potter","venice",5142345,"alex@gmail.com",5),
("bob","marley","new york",9451335,"alex@gmail.com",6),
("george","martin","venice",7421364,"alex@gmail.com",7);



#select all elements from customer table
SELECT `customer`.`id`,
    `customer`.`firstname`,
    `customer`.`lastname`,
    `customer`.`city`,
    `customer`.`phone`,
    `customer`.`email`,
    `customer`.`cs_id`
FROM `mydb`.`customer`;


#select filtered by city
SELECT `customer`.`id`,
    `customer`.`firstname`,
    `customer`.`lastname`,
    `customer`.`city`,
    `customer`.`phone`,
    `customer`.`email`,
    `customer`.`cs_id`
FROM `mydb`.`customer` WHERE city = "new york";

#select filtered by customer service id
SELECT `customer`.`id`,
    `customer`.`firstname`,
    `customer`.`city`,
    `customer`.`phone`,
    `customer`.`cs_id`
FROM `mydb`.`customer`;


SELECT `customer service`.`id`,
    `customer service`.`work_from`,
    `customer service`.`work_till`
FROM `mydb`.`customer service`;

Select * from factories;
select * from employees;
