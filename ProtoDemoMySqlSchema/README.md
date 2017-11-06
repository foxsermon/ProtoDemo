# Proto Demo Mysql Schema
Defines schema for Proto Demo Microservices or modules. Security section.

```
USE protodemo;

CREATE TABLE permissions (
	id			integer not null primary key,
    name		varchar(100),
    created 	timestamp default current_timestamp
);

CREATE TABLE roles (
	id			integer not null primary key,
    name		varchar(100),
    created		timestamp default current_timestamp
);

CREATE TABLE users (
	id			integer not null primary key,
    name		varchar(100),
    email		varchar(50),
    created		timestamp default current_timestamp
);

CREATE TABLE user_roles (
	id			integer not null auto_increment,
    userId		integer not null,
    roleId		integer not null,
    created		timestamp default current_timestamp,
    constraint pk_user_role primary key (id, userId, roleId),
    foreign key (userId) references users(id),
    foreign key (roleId) references roles(id)
);

create table role_permissions (
	id				integer not null auto_increment,
    roleId			integer not null,
    permissionId	integer not null,
    created			timestamp default current_timestamp,
    constraint pk_role_permission primary key (id, roleId, permissionId),
    foreign key (roleId) references roles(id),
    foreign key (permissionId) references permissions(id)
);

insert into permissions (id, name) values (30, 'read all');
insert into permissions (id, name) values (31, 'buy all');
insert into permissions (id, name) values (32, 'read Home, Garden & Tools');
insert into permissions (id, name) values (33, 'buy Home, Garden & Tools');
insert into permissions (id, name) values (34, 'read Electronics, Computers & Office');
insert into permissions (id, name) values (35, 'buy Electronics, Computers & Office');

insert into roles (id, name) values (100, 'full access');
insert into roles (id, name) values (101, 'full Home, Garden & Tools');
insert into roles (id, name) values (102, 'read only Home, Garden & Tools');
insert into roles (id, name) values (103, 'full Electronics, Computers & Office');
insert into roles (id, name) values (104, 'read only Electronics, Computers & Office');

insert into role_permissions (roleId, permissionId) values (100, 30);
insert into role_permissions (roleId, permissionId) values (100, 31);
insert into role_permissions (roleId, permissionId) values (101, 32);
insert into role_permissions (roleId, permissionId) values (101, 33);
insert into role_permissions (roleId, permissionId) values (102, 32);
insert into role_permissions (roleId, permissionId) values (103, 34);
insert into role_permissions (roleId, permissionId) values (103, 35);
insert into role_permissions (roleId, permissionId) values (104, 34);

insert into users (id, name) values (-2, 'Admin');
insert into users (id, name) values (-1, 'Anonymous');
insert into users (id, name, email) values (10, 'Tomas Smith', 'tomas.smith@gmail.com');

insert into user_roles (userId, roleId) values (-2, 100);
insert into user_roles (userId, roleId) values (-1, 102);
insert into user_roles (userId, roleId) values (-1, 104);
insert into user_roles (userId, roleId) values (10, 101);
insert into user_roles (userId, roleId) values (10, 103);

commit;

create or replace view v_user_access as 
select us.id as usrId, us.name as usrName, 
       ro.id as roleId, ro.name as roleName, 
       pe.id as permId, pe.name as permName
  from users us
 inner join user_roles ur on ur.userId = us.id
 inner join roles ro on ur.roleId = ro.id
 inner join role_permissions rp on rp.roleId = ro.id
 inner join permissions pe on rp.permissionId = pe.id
 order by us.id, ro.id, pe.id;
 
select * from v_user_access; 

```