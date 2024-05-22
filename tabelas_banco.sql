create table public.usuario
(
id serial primary key,
nome character varying NOT NULL,
cpf character varying not null,
senha character varying not null,
reais character varying default 0.0,
bitcoin character varying default 0.0,
ethereum character varying default 0.0,
ripple character varying default 0.0
);

create table public.extrato
(
id serial primary key,
data timestamp default current_timestamp,
tipo boolean,
valor character varying not null,
cotacao character varying not null,
nome_moeda character varying not null,
reais character varying not null,
bitcoin character varying not null,
ethereum character varying not null,
ripple character varying not null,
id_pessoa int not null
);

INSERT INTO public.usuario(
	id, nome, cpf, senha, reais, ripple, ethereum, bitcoin)
	VALUES ('1', 'Prof Gabriela', '12345678910', '123456', 0, 0, 0, 0);
