create table xorder (
  id bigint not null auto_increment,
  amount integer not null,
  client_id bigint,
  genereted_at datetime not null,
  product_name varchar(255) not null,
  product_value decimal(19,2),
  ref varchar(255) not null,
  total decimal(19,2),
  primary key (id)
);

alter table xorder
add constraint order_ref_uk
unique (ref);

insert into xorder
(amount, client_id, genereted_at, product_name, product_value, ref)
values ( 10, 1, now(), 'produto verde', '2.39', 'ref#1' );
insert into xorder
(amount, client_id, genereted_at, product_name, product_value, ref)
values ( 4, 2, now(), 'produto verde', '10.0', 'ref#2' );
insert into xorder
(amount, client_id, genereted_at, product_name, product_value, ref)
values ( 19, 3, now(), 'produto vermelho', '130.2', 'ref#3' );
insert into xorder
(amount, client_id, genereted_at, product_name, product_value, ref)
values ( 16, 4, now(), 'produto preto', '73.19', 'ref#4' );
insert into xorder
(amount, client_id, genereted_at, product_name, product_value, ref)
values ( 22, 5, now(), 'produto cinza', '13.5', 'ref#5' );
insert into xorder
(amount, client_id, genereted_at, product_name, product_value, ref)
values ( 49, 6, now(), 'produto azul', '2.40', 'ref#6' );
insert into xorder
(amount, client_id, genereted_at, product_name, product_value, ref)
values ( 9, 7, now(), 'produto ver elho', '2.41', 'ref#7' );
insert into xorder
(amount, client_id, genereted_at, product_name, product_value, ref)
values ( 2, 8, now(), 'produto cinza', '12.1', 'ref#8' );
insert into xorder
(amount, client_id, genereted_at, product_name, product_value, ref)
values ( 7, 9, now(), 'produto preto', '22.9', 'ref#9' );
insert into xorder
(amount, client_id, genereted_at, product_name, product_value, ref)
values ( 8, 10, now(), 'produto marrom', '2.39', 'ref#10' );

