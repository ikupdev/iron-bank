drop table if exists bank;
create table bank
(
    id      bigint       not null primary key,
    name    varchar(255) not null,
    balance bigint not null
);
insert into bank values (1, 'Braavos Bank', 1000000);
insert into bank values (2, 'Targarian', 0);
insert into bank values (3, 'Stark', 0);