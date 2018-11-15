
create database if not exists leilao;

use leilao;

create table if not exists usuario (
    id int auto_increment not null,
    nome varchar(30),
    total_lances int default 0,
    total_itens_ganhos int default 0,
    tipo_conta varchar(30) default 'participante',
    login varchar(30) not null,
    senha varchar(30) not null,
    primary key (id)
);

create table if not exists item (
    id int auto_increment not null,
    vendedor int not null,
    nome varchar(30) not null,
    descricao varchar(180),
    valor_inicial decimal(3, 2) not null,
    valor_atual decimal(3, 2) not null,
    senha varchar(30) not null,
    primary key (id),
    foreign key (vendedor) references usuario(id)
);


insert into usuario (nome, total_lances, total_itens_ganhos, tipo_conta, login, senha) 
              values ('Robson', 0, 0, 'leiloeiro', 'robson@gmail.com', 'senha123');


insert into usuario (nome, total_lances, total_itens_ganhos, tipo_conta, login, senha) 
              values ('Cleyton', 0, 0, 'leiloeiro', 'cleyton@gmail.com', 'senha123');