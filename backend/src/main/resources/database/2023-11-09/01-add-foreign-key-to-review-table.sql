--liquibase formatted sql
--changeset pmigaj:11
alter table review add foreign key (product_id) references product(id);