-- 34
SELECT AVG(AMOUNT)
FROM ORDERS;

SELECT REP, AVG(AMOUNT)
FROM ORDERS
GROUP BY REP;

SELECT REP_OFFICE, MIN(QUOTA), MAX(QUOTA)
FROM SALESREPS
GROUP BY REP_OFFICE;

SELECT REP_OFFICE, COUNT(*)
FROM SALESREPS
GROUP BY REP_OFFICE;

SELECT COUNT(DISTINCT CUST_NUM), CUST_REP
FROM CUSTOMERS
GROUP BY CUST_REP;

SELECT REP, CUST, SUM(AMOUNT)
FROM ORDERS
GROUP BY REP, CUST;

SELECT REP, CUST, SUM(AMOUNT)
FROM ORDERS
GROUP BY REP, CUST
ORDER BY REP, CUST;

-- 35
SELECT S.EMPL_NUM, S.NAME, SUM(AMOUNT) FROM ORDERS O
INNER JOIN SALESREPS S ON S.EMPL_NUM = O.REP
GROUP BY S.EMPL_NUM, S.NAME;

INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Cindy', 'Brown', 'Blue')
/
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Louise', NULL, 'Blue')
/
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Harry', NULL, 'Blue')
/
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Samantha', NULL, NULL)
/
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Joanne', NULL, NULL)
/
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('George', 'Brown', NULL)	
/
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Mary', 'Brown', NULL)	
/
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Paula', 'Brown', NULL)	
/
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Kevin', 'Brown', NULL)	
/
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Joel', 'Brown', 'Brown')	
/
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Susan', 'Blonde', 'Blue')	
/
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Marie', 'Blonde', 'Blue')	
/
COMMIT
/

SELECT HAIR, EYES, COUNT(*) FROM COLORIS
GROUP BY HAIR,EYES;

-- 36
SELECT REP, AVG(AMOUNT)
FROM ORDERS
GROUP BY REP
HAVING SUM(AMOUNT) > 300;

SELECT CITY, SUM(QUOTA), SUM(SALESREPS.SALES) FROM OFFICES
INNER JOIN SALESREPS ON OFFICE = REP_OFFICE
GROUP BY CITY
HAVING COUNT(*) >= 2;

SELECT DESCRIPTION, PRICE, QTY_ON_HAND, SUM(QTY) FROM PRODUCTS P
INNER JOIN ORDERS O ON p.product_id = o.product 
GROUP BY MFR_ID, PRODUCT_ID, DESCRIPTION, PRICE, QTY_ON_HAND
HAVING SUM(QTY) > (0.75 * QTY_ON_HAND)
ORDER BY QTY_ON_HAND DESC;

--1
select p.description, sum(o.qty) from products p
inner join orders o on p.product_id = o.product
group by p.description;

--2
select p.description, count(o.qty) from products p
inner join orders o on p.product_id = o.product
group by p.description
having count(o.qty) > 3;

--3
select o.city, o.office, count(s.empl_num) from offices o
inner join salesreps s on s.rep_office = o.office 
group by o.office, o.city
having count(s.empl_num) > 3;

--4
select o.city, o.office, avg(s.age) from offices o
inner join salesreps s on s.rep_office = o.office 
group by o.office, o.city;

--5
select p.mfr_id, count(p.product_id) from products p
group by p.mfr_id
having count (p.product_id) > 4;

--6
select p.mfr_id, sum(p.qty_on_hand), count(p.product_id) from products p
group by p.mfr_id
having count(p.product_id) > 4;

--6 with subquery
select p.mfr_id, sum(p.qty_on_hand), count(p.product_id) from products p
where p.mfr_id in (select mfr_id from products group by mfr_id having count(*) > 4)
group by p.mfr_id;

--7 with subquery
select cust_num, company, avg(o.amount) from customers c
inner join orders o on c.cust_num = o.cust
where o.mfr in (select mfr_id from products group by mfr_id having count(*) > 4)
group by cust_num, company, o.mfr;

--8 with subquery
select max(orders_count), min(orders_count) from
(select count(*) as orders_count from orders
where rep in (select manager from salesreps group by manager having count(*) > 2)
group by rep);

--9
select * from products
where regexp_like(description,'[аАaA].*[аАaA]');

insert into ma_student.boys(NM, NAME, CITY) values((select max(nm) from boys) + 1 , 'Poul', 'Chalfont');

insert into ma_student.boys(NM, NAME, CITY)
select ((select max(nm) from boys) + row_number() over (order by empl_num)) as new_id,
regexp_substr(s.name, '.+ ') as name, o.city from salesreps s
inner join offices o on s.rep_office = o.office
where regexp_like(s.name, 'Игорь|Дима|Максим|Вася|Филип');

update ma_student.boys
set city = 'Gazz Chamber'
where city is null;

update ma_student.girls
set name = 'Hucker'
where city = 'Chicago';

delete from boys where city = 'Gazz Chamber';
delete from girls where name = 'Hucker';

commit;
