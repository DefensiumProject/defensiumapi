create table if not exists tb_plataforma (
    codigo bigserial not null,
    nome varchar (100) not null,
    ativa boolean not null default true,
    data_criacao timestamp not null default now(),
    data_edicao timestamp not null default now(),
    data_delecao timestamp not null default now(),
    constraint pk_plataforma primary key (codigo),
    constraint un_plataforma_nome unique (nome)
);