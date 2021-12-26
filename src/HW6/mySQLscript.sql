create table products
(
    id         decimal primary key,
    title      varchar(255),
    price      decimal(7, 2)
);

insert into products
    (title, price)
values
    ('Banana', 50),
    ('Bread', 40),
    ('Meat', 500);
