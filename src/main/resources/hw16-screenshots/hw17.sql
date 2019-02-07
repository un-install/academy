--step 26

--output all order's num, amout with it customer's company and cust_num
select order_num, amount, c.company, c.credit_limit from orders o 
inner join customers c on o.cust = c.cust_num;

--output all mgr's name with his ofice's city, region 
select s.name, city, region from offices o
inner join salesreps s on o.office = s.rep_office;

--output all ofice's city with it's mgr's name, title
select o.city, name, title from salesreps s
inner join offices o on s.empl_num = o.mgr;

--output all ofice's city with it's mgr's name, title, with target > 600
select o.city, name, title from salesreps s
inner join offices o on o.target > 600 and s.empl_num = o.mgr;

--output all order's order_num, amount with it's product's description
select order_num, amount, p.description from orders o
inner join products p on o.mfr = p.mfr_id and o.product = p.product_id;

--step 27

--i m tired to provide small logic comments about task
--so, there and after will be google translate

--Print a list of orders worth over $ 700
--including the name of the employee who accepted the order and the name of the client who made it
select order_num, amount, c.company, s.name from orders o
inner join customers c on o.cust = c.cust_num
inner join salesreps s on o.rep = s.empl_num and o.amount > 700;

--Print a list of orders worth over $ 700
--including the name of the customer who placed the order and the name of the employee assigned to that customer.
select order_num, amount, c.company, s.name from orders o
inner join customers c on o.cust = c.cust_num
inner join salesreps s on c.cust_rep = s.empl_num and o.amount > 700;

--List orders above $ 700
--including the name of the customer who placed the order
--and the name of the employee assigned to that customer, as well as the office where the employee works
select order_num, amount, c.company, s.name, ofc.city from orders o
inner join customers c on o.cust = c.cust_num
inner join salesreps s on c.cust_rep = s.empl_num 
inner join offices ofc on s.rep_office = ofc.office and o.amount > 700;

--step 28

--Find all orders received on the day when a new employee was hired
select order_num, amount, order_date, s.name, s.hire_date from orders o
inner join salesreps s on o.order_date = s.hire_date;

--Get all the combinations of employees offices
--where the planned sales volume of the employee is greater than the plan of any office.
select name, quota, o.city, o.target from salesreps s
inner join offices o on s.quota > o.target;

--Show each employee's name, office, and sales
select name, s.sales, o.city from salesreps s
inner join offices o on s.rep_office = o.office;

--Show the names of cities in which actual sales exceed planned
select city, sales from offices where sales > target;

--Show the names of employees whose sales are above $ 1000.
select name, sales from salesreps where sales > 200;

--Report all information about employees and offices where they work.
select * from salesreps
inner join offices on rep_office = office;
select s.*, o.city, o.region from salesreps s
inner join offices o on rep_office = office;

--step 30

--list the names of all employees and their managers
select s1.name, s2.name from salesreps s1
inner join salesreps s2 on s1.manager = s2.empl_num;

--Display a list of employees whose plans exceed the plans of their leaders
select s.name, s.quota, mgrs.quota from salesreps s
inner join salesreps mgrs on s.manager = mgrs.empl_num and s.quota > mgrs.quota;

--Display a list of employees who work with their managers in various offices
--including the names and offices of both employees and managers.
select s.name, so.city, mgrs.name, mgrso.city from salesreps s
inner join offices so on s.rep_office = so.office
inner join salesreps mgrs on s.manager = mgrs.empl_num and s.rep_office <> mgrs.rep_office
inner join offices mgrso on mgrs.rep_office = mgrso.office;

--output all name of offices with their workers
select s.name, city from offices o
inner join salesreps s on o.office is not null;

--step 31

--Output averege quota and avg sales from salesreps
select avg(quota), avg(sales) from salesreps;

--Output averege plan-execution from salesreps
select avg(100 * (sales/quota)) from salesreps;
select avg(100 * (sales/quota)) procent from salesreps;

--Output sum of quota and sales from salesreps
select sum(quota), sum (sales) from salesreps;

--Output amount of all offers recived by Dima Malkov
select sum(amount) from salesreps s
inner join orders o on s.name = '���� �������' and o.rep = s.empl_num;
--Amount mean a profit, horrible naming

--Output avg price of ACI manufacturer products
select avg(price) from products where mfr_id = 'ACI';

--Output avg amount of 2103 custumer's offers; 
select avg(amount) from orders where cust = 2103;

--step 32

--Output minimal and maximal quota from salereps
select min(quota), max(quota) from salesreps;

--Output date of oldest order
select min(order_date) from orders;

--Output percent of plant executing of most succssful saler
select max(100 * (sales/quota)) from salesreps;

--How many clients do we have
select count(*)from customers;

--how many salers done the plan
select count(*) from salesreps where sales > quota;

--Output all quantity of orders with an amount > 250;
select count(*) from orders where amount > 250;

--Find the average cost of orders, the total cost of orders, the average cost
--of orders as a percentage of customer loan limits,
--as well as the average cost of orders as a percentage of the planned sales of employees.
select avg(amount), sum(amount), (100 * avg(amount/credit_limit)), (100 * avg(amount/quota)) from orders o
inner join customers c on o.cust = c.cust_num
inner join salesreps s on o.rep = s.empl_num;
    
select amount, amount, amount/credit_limit, amount/quota from orders o
inner join customers c on o.cust = c.cust_num
inner join salesreps s on o.rep = s.empl_num;

select distinct c.* from customers c
inner join orders o on c.cust_num = o.cust
inner join products p on o.product = p.product_id
and p.description like '%A%' or p.description like '%a%' or p.description like '%�%' or p.description like '%�%';