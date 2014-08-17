create database if not exists ebookshop;

use ebookshop;

drop table if exists books;
create table books (
  id     int NOT NULL auto_increment ,
  title  varchar(50),
  author varchar(50),
  price  double,
  qty    int,
  primary key (id));

insert into books values (1001, 'Java for dummies', 'Tan Ah Teck', 11.11, 11);
insert into books values (1002, 'More Java for dummies', 'Tan Ah Teck', 22.22, 22);
insert into books values (1003, 'More Java for more dummies', 'Mohammad Ali', 33.33, 33);
insert into books values (1004, 'A Cup of Java', 'Kumar', 44.44, 44);
insert into books values (1005, 'A Teaspoon of Java', 'Kevin Jones', 55.55, 55);

drop table if exists user;
create table users (
  id int not null auto_increment ,
  name   varchar (50),
  email  varchar (30),
  phone  varchar (30),
  permission int,
  password varchar (30),
  primary key (id)
);

drop table if exists order_records;
create table order_records (
  id int not null auto_increment ,
  user_id int ,
  product_id int,
  qty_ordered int,
  primary key (id),
  foreign key (user_id) REFERENCES users(id),
  foreign key (product_id) references books(id)
);