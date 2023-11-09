--liquibase formatted sql
--changeset pmigaj:9
create table review(
    id bigint not null auto_increment primary key,
    product_id bigint not null,
    author_name varchar(60) not null,
    content text
);