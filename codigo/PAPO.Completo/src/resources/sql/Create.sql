create table if not exists "aluno"
(
    "id"        char(36) not null,
    "username"  varchar not null,
    "nome"      varchar not null,
    "email"     varchar not null,
    "telefone"  char(11) not null,
    "senha"     varchar not null,
    "genero"    char,
    "datanasc"  char(10),
    "cep"       char(8),
    "cidade"    varchar,
    "estado"    varchar,
    "papel"     char,
    "descricao" varchar,
    constraint aluno_pk
        primary key ("id")
);

create unique index if not exists aluno_idalu_uindex
    on "aluno" ("id");

create unique index if not exists aluno_telefone_uindex
    on "aluno" ("telefone");

create unique index if not exists aluno_username_uindex
    on "aluno" ("username");

create table if not exists "professor"
(
    "id"          char(36) not null,
    "username"    varchar not null,
    "nome"        varchar not null,
    "email"       varchar not null,
    "telefone"    char(11) not null,
    "senha"       varchar not null,
    "genero"      char,
    "datanasc"    char(10),
    "cep"         char(8),
    "cidade"      varchar,
    "estado"      varchar,
    "papel"       char,
    "experiencia" integer,
    "descricao"   varchar,
    constraint professor_pk
        primary key ("id")
);

create unique index if not exists professor_email_uindex
    on "professor" ("email");

create unique index if not exists professor_id_uindex
    on "professor" ("id");

create unique index if not exists professor_telefone_uindex
    on "professor" ("telefone");

create unique index if not exists professor_username_uindex
    on "professor" ("username");

create table if not exists "materia"
(
    "sigla" char(5) not null,
    "nome"  varchar not null,
    constraint materia_pk
        primary key ("sigla")
);

create unique index if not exists materia_sigla_uindex
    on "materia" ("sigla");

create table if not exists "leciona"
(
    "id"            integer not null,
    "professor_Id"  char(36) not null,
    "aluno_Id"      char(36) not null,
    "descricao"     varchar,
    "valor"         double precision,
    "materia_Sigla" char(5) not null,
    "horario"       varchar not null,
    constraint leciona_pk
        primary key ("id"),
    constraint "Professor_Id_Fk"
        foreign key ("professor_Id") references "professor"
            on update cascade on delete set null,
    constraint "Aluno_Id_Fk"
        foreign key ("aluno_Id") references "aluno"
            on update cascade on delete set null,
    constraint "Leciona_Materia_Fk"
        foreign key ("materia_Sigla") references "materia"
            on update cascade on delete set null
);

create unique index if not exists leciona_aluno_id_uindex
    on "leciona" ("aluno_Id");

create unique index if not exists leciona_id_uindex
    on "leciona" ("id");

create unique index if not exists leciona_professor_id_uindex
    on "leciona" ("professor_Id");

create table if not exists "avalia"
(
    "professor_Id" char(36) not null,
    "aluno_Id"     char(36) not null,
    "avaliacao"    integer not null,
    "comentario"   varchar,
    constraint "Avalia_pk"
        primary key ("professor_Id", "aluno_Id"),
    constraint "Avalia_Professor_Fk"
        foreign key ("professor_Id") references "professor"
            on update cascade on delete set null,
    constraint "Avalia_Aluno_Fk"
        foreign key ("aluno_Id") references "aluno"
            on update cascade on delete set null
);

create unique index if not exists avalia_aluno_id_uindex
    on "avalia" ("aluno_Id");

create unique index if not exists avalia_professor_id_uindex
    on "avalia" ("professor_Id");