insert into usuario (id, nome, login, senha, ativo) values (1, 'Danilao da Motossera', 'danilo', 
'$2a$10$OTX8Z7VX7g1a3Way2H4kYOHe2EYOGjJsgWTql.0dZoWjQ6u4oBJfW', true);
insert into usuario (id, nome, login, senha, ativo) values (2, 'Higor Hermes', 'higor', 
'$2a$10$OTX8Z7VX7g1a3Way2H4kYOHe2EYOGjJsgWTql.0dZoWjQ6u4oBJfW', true);
insert into usuario (id, nome, login, senha, ativo) values (3, 'Luana Martins', 'luana', 
'$2a$10$OTX8Z7VX7g1a3Way2H4kYOHe2EYOGjJsgWTql.0dZoWjQ6u4oBJfW', true);
insert into usuario (id, nome, login, senha, ativo) values (4, 'Higor Hermes 2', 'hermes', 
'$2a$10$OTX8Z7VX7g1a3Way2H4kYOHe2EYOGjJsgWTql.0dZoWjQ6u4oBJfW', true);

insert into grupo (id, nome, descricao) values (1, 'ANALISTA', 'Grupo de analistas');
insert into grupo (id, nome, descricao) values (2, 'ORGANIZADOR', 'Grupo de organizadores da festa');
insert into grupo (id, nome, descricao) values (3, 'CONVIDADO', 'Grupo de participantes da festa');



insert into permissao (id, nome) values (1, 'BASICO');
insert into permissao (id, nome) values (2, 'CADASTRAR_FESTAS');
insert into permissao (id, nome) values (3, 'CADASTRAR_CONVIDADOS');


insert into usuario_grupos (usuarios_id, grupos_id) values (1, 1);
insert into usuario_grupos (usuarios_id, grupos_id) values (2, 2);
insert into usuario_grupos (usuarios_id, grupos_id) values (3, 3);

insert into usuario_grupos (usuarios_id, grupos_id) values (4, 2);


insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 1);
insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 2);
insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 3);

insert into grupo_permissoes (grupos_id, permissoes_id) values (2, 2);
insert into grupo_permissoes (grupos_id, permissoes_id) values (3, 3);

