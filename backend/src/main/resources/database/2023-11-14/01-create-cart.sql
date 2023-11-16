--liquibase formatted sql
--changeset pmigaj:12

create table cart(
    id  bigint not null auto_increment primary key,
    created datetime not null 
);

create table cart_item(
    id bigint not null auto_increment primary key,
    product_id bigint not null,
    cart_id bigint not null, 
    quantity int 
);

alter table cart_item add constraint fk_cart_item_product_id foreign key (product_id) references product(id);
alter table cart_item add constraint fk_cart_item_cart_id foreign key (cart_id) references cart(id);