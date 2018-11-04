DROP TABLE PRODUCTS;
create table products(product_id varchar(64),product_name varchar(64),price DECIMAL(5,2),price_currency varchar(64),color varchar(64));
insert into products(product_id,product_name,price,price_currency,color)
values('PRD1','NOKIA 6.1 PLUS',355.50,'USD','WHITE');
insert into products(product_id,product_name,price,price_currency,color)
values('PRD2','MOTO POWER ONE',99.60,'USD','BLACK');
