show databases;

create database User;
use User;

show tables;

drop table user;

create table user(userName varchar(50),userPassword varchar(50));
create table user(email varchar(50), firstName varchar(50), lastName varchar(50),userName varchar(50), phoneNo varchar(10), password varchar(50),verified boolean default 0, hashcode varchar(50));

select * from user; 


insert into user value('test@test.com', 'test','test','test2','1','test');
insert into user value('yojana', 'yojana@123');
insert into user value('kalpana', 'kalpana@123');
insert into user value('bishnu', 'bishnu@123');

drop table user;
alter table user alter verified set default 0;

alter table user add hashCode varchar(10);

select * from user where userName='test2' and password='test';
select * from user where email='test2';


DELETE FROM user 
WHERE
    email = 'gautamyojan0@gmail.com';
