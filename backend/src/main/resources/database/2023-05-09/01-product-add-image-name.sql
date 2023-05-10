--liquibase formatted sql
--changeset pmigaj:3
alter table product add image varchar(128) after currency;
