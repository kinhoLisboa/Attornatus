create table funcionario(

id bigint not null auto_increment ,
nome varchar(60) not null,
idade varchar(60) not null,
cep varchar (60) not null,
sexo varchar (10),
endereco varchar (60),
bairro varchar (60),
cidade varchar(60),
estado varchar(60),
primary key(id)
);