CREATE TABLE ORDERS (
ORDER_NUM decimal primary key,
	ORDER_DATE DATE,
	CUST decimal,
	REP decimal,
	MFR VARCHAR2(3),
	PRODUCT VARCHAR2(5),
	QTY decimal,
	AMOUNT decimal);