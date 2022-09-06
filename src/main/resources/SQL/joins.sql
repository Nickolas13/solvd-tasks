SELECT company.id, employees.firstname, employees.lastname
FROM employees
INNER JOIN company ON employees.company_id=company.id;


SELECT employees.email, employees.id,
customerservice.work_from, customerservice.work_till
FROM employees
LEFT JOIN customerservice ON employees.cs_id = customerservice.id;


SELECT employees.id, employees.email, customerservice.location,
customerservice.work_from, customerservice.work_till
FROM employees
RIGHT JOIN customerservice ON employees.cs_id = customerservice.id;


SELECT customerservice.location, customer.firstname, customer.lastname
FROM customerservice
RIGHT JOIN customer ON customerservice.id=customer.cs_id;



SELECT * FROM customer 
LEFT JOIN customerservice ON customer.cs_id = customer.id
UNION
SELECT * FROM customer
RIGHT JOIN customerservice ON customer.cs_id = customer.id;




