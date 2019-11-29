create table product_groups
(
  group_id   bigint auto_increment
    primary key,
  group_name varchar(255) not null
);

create table products
(
  product_id    bigint auto_increment
    primary key,
  description   varchar(255) null,
  product_name  varchar(255) null,
  price         double       null,
  product_group bigint       not null,
  foreign key (product_group) references product_groups (group_id)
);

create index FKauhegmfml011wmqsj2m0n60gc
  on products (product_group);

create table users
(
  user_id       bigint auto_increment
    primary key,
  user_name     varchar(255) null,
  basket_id     bigint       not null,
  user_property bigint       not null

);

create table user_property
(
  property_id  bigint auto_increment
    primary key,
  email        varchar(255) null,
  login        varchar(255) null,
  password     varchar(255) null,
  user_user_id bigint       not null,
  unique (user_user_id),
  foreign key (user_user_id) references users (user_id)
);

create table baskets
(
  basket_id bigint auto_increment
    primary key,
  user_id   bigint not null,
  unique (user_id),
  foreign key (user_id) references users (user_id)
);

create table product_basket
(
  basket_id  bigint not null,
  product_id bigint not null,
  foreign key (basket_id) references baskets (basket_id),
  foreign key (product_id) references products (product_id)
);

create index FK74x5kkyridqxcfxxxpo78ahke
  on product_basket (basket_id);

create index FKfqjo24ingkg1vl2lc7o919wnl
  on product_basket (product_id);

insert into product_groups values
  (1,"cakes"),
  (2,"sweets"),
  (3,"biscuits"),
  (4,"drinks");

insert into products(product_name,price,description,product_group) values
  ("clocolate cake",4,"chocolate",1),
  ("cream cake",5,"cream",1),
  ("cow",7,"cow",2),
  ("nuts",8,"nuts",2),
  ("Homemade cookie",7,"with sugar",3),
  ("biscuit \"Serpentine\"",7,"cow",3),
  ("pepsi",2,"pepsi",4),
  ("cola",2,"cola",4);