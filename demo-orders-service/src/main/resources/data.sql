DROP TABLE PRODUCT_ORDER;
create table PRODUCT_ORDER(order_Id varchar(64),user_Id varchar(64),product_Id varchar(64),order_Date DATE,payment_Method varchar(64),status varchar(16));
insert into PRODUCT_ORDER(order_Id,user_Id,product_Id,order_Date,payment_Method, status)
values('ORD1','USR1','PRD1','2018-10-10','CASH','COMPLETED');
insert into PRODUCT_ORDER(order_Id,user_Id,product_Id,order_Date,payment_Method, status)
values('ORD2','USR2','PRD2','2018-10-10','ONLINE','COMPLETED');
