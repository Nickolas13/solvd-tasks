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
(`id`,
`name`,
`prod_type`,
`pa_month`,
`company_id`)
VALUES
(1,"thefactory","clothes",10000,1),
(2,"bakingfactory","bread",20000,2),
(3,"sweets","candy",50000,1),
(4,"electronics","laptop",5000,1),
(5,"building","stones",100000,2);


#adding  employees
INSERT INTO `mydb`.`employees`
(`id`,
`firstname`,
`lastname`,
`email`,
`company_id`,
`factories_id`,
`customer service_id`)
VALUES
(1,"steve","wick","steve@gmail.com",1,3,4),
(2,"steve","wick","steve@gmail.com",1,1,3),
(3,"steve","wick","steve@gmail.com",2,3,5),
(4,"steve","wick","steve@gmail.com",1,5,1);


#inserting elements in customer service
INSERT INTO `mydb`.`customer service`
(`id`,`location`,`work_from`,`work_till`)
VALUES
(1,"smth street","monday","friday"),
(2,"smth street","tuesday","friday"),
(3,"smth street","monday","saturday"),
(4,"smth street","monday","thursday"),
(5,"smth street","monday","sunday"),
(6,"smth street","wednesday","sunday"),
(7,"smth street","monday","friday");


#inserting customers
INSERT INTO `mydb`.`customer`
(`id`,
`firstname`,
`lastname`,
`city`,
`phone`,
`email`,
`cs_id`)
VALUES
(1,"alex","anderson","san francisco",785421,"alex@gmail.com",1),
(2,"bob","smith","san francisco",621345,"bob@gmail.com",2),
(3,"john","wick","new york",367984,"john@gmail.com",3),
(4,"gigi","anderson","california",6874321,"alex@gmail.com",4),
(5,"arina","potter","venice",5142345,"alex@gmail.com",5),
(6,"bob","marley","new york",9451335,"alex@gmail.com",6),
(7,"george","martin","venice",7421364,"alex@gmail.com",7);



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
FROM `mydb`.`customer` WHERE cs_id = 2;


SELECT `customer service`.`id`,
    `customer service`.`work_from`,
    `customer service`.`work_till`
FROM `mydb`.`customer service`;



