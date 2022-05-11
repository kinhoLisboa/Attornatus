create table venda(

id bigint not null auto_increment,
data_venda datetime not null,
valor decimal(10,2) not null,
vendedor_id varchar(60) not null,

primary key (id)

);

alter table venda add constraint fk_venda_vendedor foreign key(vendedor_id) references vendedor (id );