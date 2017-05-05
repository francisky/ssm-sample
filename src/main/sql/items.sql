create table items(
id integer primary key auto_increment,
name varchar(30) not null,
price double,
createtime timestamp not null default current_timestamp,
detail varchar(100));

insert into items(name,price,detail) values("雪碧",3.0,"饮料");
insert into items(name,price,detail) values("可乐",3.0,"饮料");
insert into items(name,price,detail) values("薯片",8.0,"膨化食品");
insert into items(name,price,detail) values("牛奶",3.5,"乳制品");
insert into items(name,price,detail) values("樱桃",99,"水果");