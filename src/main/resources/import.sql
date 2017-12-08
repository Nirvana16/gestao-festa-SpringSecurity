insert into usuario (id, nome, login, senha, ativo) values (1, 'Danilao da Motossera', 'danilo', '$2a$10$OTX8Z7VX7g1a3Way2H4kYOHe2EYOGjJsgWTql.0dZoWjQ6u4oBJfW', true);
insert into grupo (id, nome, descricao) values (1, 'ANALISTA', 'Grupo de analistas');
insert into permissao (id, nome) values (1, 'USUARIO');
insert into permissao (id, nome) values (2, 'VISUALIZAR_RELATORIO_CUSTOS');
insert into permissao (id, nome) values (3, 'VISUALIZAR_RELATORIO_EQUIPE');
insert into usuario_grupos (usuarios_id, grupos_id) values (1, 1);
insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 1);
insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 2);
insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 3);
