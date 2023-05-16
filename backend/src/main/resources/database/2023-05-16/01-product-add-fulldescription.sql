--liquibase formatted sql
--changeset pmigaj:5
alter table product add full_description text default null after  description;