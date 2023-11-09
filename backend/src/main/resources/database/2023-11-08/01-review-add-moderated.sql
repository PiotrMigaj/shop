--liquibase formatted sql
--changeset pmigaj:10
alter table review add moderated boolean default false;