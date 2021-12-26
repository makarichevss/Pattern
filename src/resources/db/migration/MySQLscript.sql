create table users
(
    id         decimal primary key,
    username   varchar(30) not null unique,
    password   varchar(80) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table roles
(
    id         decimal primary key,
    name       varchar(50) not null unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE users_roles
(
    user_id int not null references users (id),
    role_id int not null references roles (id),
    primary key (user_id, role_id)
);

create table products
(
    id         decimal primary key,
    title      varchar(255),
    price      numeric(10, 2),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table categories
(
    id          decimal primary key,
    title       varchar(255),
    description varchar(5000)
);

create table products_categories
(
    product_id  int,
    category_id int,
    foreign key (product_id) references products (id),
    foreign key (category_id) references categories (id)
);

create table orders
(
    id         decimal primary key,
    owner_id   int references users (id),
    price      numeric(10, 2),
    address    varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table order_items
(
    id                decimal primary key,
    order_id          int references orders (id),
    product_id        int references products (id),
    title             varchar(255),
    quantity          int,
    price_per_product numeric(10, 2),
    price             numeric(10, 2),
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);

insert into roles
    (name)
values
    ('ROLE_USER'),
    ('ROLE_ADMIN');

insert into users
    (username, password, email)
values
    ('alan1', '$2y$12$yr/ojWL6JQCpku.5vlcGuuIAkROTMOkIupVUzzRMqQvBqpUgn4xA2', 'alan1@mail.ru'),
    ('alan2', '$2y$12$yr/ojWL6JQCpku.5vlcGuuIAkROTMOkIupVUzzRMqQvBqpUgn4xA2', 'alan2@mail.ru');

insert into users_roles
    (user_id, role_id)
values
    (1, 1),
    (2, 2);

insert into products
    (title, price)
values
    ('Banana', 50),
    ('Bread', 40),
    ('Meat', 500);


insert into categories
    (title, description)
values
    ('food', 'some food products'),
    ('fruits', 'some fruit'),
    ('vegetables', 'some vegetables'),
    ('electronics', 'some electronics'),
    ('non-food', 'all non-food products');