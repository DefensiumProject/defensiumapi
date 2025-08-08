create table if not exists tb_credencial (
    codigo bigserial not null,
    codigo_publico uuid default gen_random_uuid(),
    id_plataforma bigserial not null,
    descricao varchar (100) not null,
    usuario varchar (60) not null,
    senha varchar (100) not null,
    url varchar (255) null,
    data_criacao timestamp not null default now(),
    data_edicao timestamp not null default now(),
    data_delecao timestamp not null default now(),
    constraint pk_credencial primary key (codigo),
    constraint pk_plataforma foreign key (id_plataforma) references tb_plataforma (codigo),
    constraint un_credencial unique (id_plataforma, descricao)
);