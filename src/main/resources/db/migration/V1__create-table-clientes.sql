create table clientes (
    id bigserial not null,
    nome varchar(255) not null,
    telefone varchar(255) not null,
    senha varchar(255) not null,

    primary key (id)

)