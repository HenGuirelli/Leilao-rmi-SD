
create database if not exists leilao;

use leilao;

create table if not exists usuario (
    nome varchar(30),
    total_lances int default 0,
    total_itens_ganhos int default 0,
    tipo_conta varchar(30) default 'participante',
    login varchar(30) not null,
    senha varchar(30) not null,
    primary key (login)
);

create table if not exists item (
    id int auto_increment not null,
    vencedor varchar(30),
    nome varchar(30) not null,
    descricao varchar(180),
    valor_inicial double not null,
    valor_atual double not null,
    senha varchar(30) not null,
    em_leilao boolean default true,
    primary key (id)
);


insert into usuario (nome, total_lances, total_itens_ganhos, tipo_conta, login, senha) 
              values ('Robson', 0, 0, 'leiloeiro', 'robson@gmail.com', 'senha123');


insert into usuario (nome, total_lances, total_itens_ganhos, tipo_conta, login, senha) 
              values ('Cleyton', 0, 0, 'leiloeiro', 'cleyton@gmail.com', 'senha123');
