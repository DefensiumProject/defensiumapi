create table if not exists tb_plataforma (
    codigo bigserial not null,
    nome varchar (100) not null,
    ativa boolean not null default true,
    data_criacao timestamp not null default now(),
    -- icone bytea null,
    icone varchar null,
    url varchar null,
    data_edicao timestamp null,
    data_delecao timestamp null,
    constraint pk_plataforma primary key (codigo),
    constraint un_plataforma_nome unique (nome)
);

-- alter table tb_plataforma add column icone bytea null;
-- alter table tb_plataforma add column url varchar null;