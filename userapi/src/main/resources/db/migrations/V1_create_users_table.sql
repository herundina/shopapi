CREATE SCHEMA IF NOT EXISTS users;

CREATE TABLE users.user(
    id bigserial primary key unique not null,
    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    endereco VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    telefone VARCHAR(150) NOT NULL,
    dtcadastro timeStamp NOT NULL
);

/*ALTER TABLE users.user ADD COLUMN KEY VARCHAR(100) NOT NULL;*/